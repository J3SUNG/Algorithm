#include <iostream>
#include <string>
#include <vector>
#include <tuple>
#include <algorithm>
using namespace std;

tuple<int, bool> func(int n, vector<int> weak, vector<int> dist)
{
  int count = 200;

  for (int i = 0; i < weak.size(); ++i)
  {
    if (dist.size() == 0)
    {
      return make_tuple(0, false);
    }

    vector<int> tempWeak = weak;
    vector<int> tempDist = dist;

    int num = tempWeak[i];
    int dis = dist.back();
    int index = i;

    while (dis >= 0 && tempWeak.size() > 0)
    {
      tempWeak.erase(tempWeak.begin() + index); 
      if (tempWeak.size() == 0)                 
      {
        return make_tuple(1, true);
      }
      if (i >= tempWeak.size()) 
      {
        index = 0;
      }

      dis -= min(abs(tempWeak[index] - num), abs(n - num + tempWeak[index])); 
      num = tempWeak[index];                                                  
    }
    tempDist.erase(tempDist.end() - 1); 

    if (tempDist.size() > 0 && tempWeak.size() > 0) 
    {
      tuple<int, bool> returnData; 
      returnData = func(n, tempWeak, tempDist);
      if (get<1>(returnData))
      {
        count = min(count, get<0>(returnData));
      }
    }
  }

  if (count == 200)
  {
    return make_tuple(1, false);
  }

  return make_tuple(count + 1, true);
}

int solution(int n, vector<int> weak, vector<int> dist)
{
  int answer;

  tuple<int, bool> returnData;
  returnData = func(n, weak, dist);
  if (!get<1>(returnData))
  {
    return -1;
  }
  answer = get<0>(returnData);

  return answer;
}

int main(int argc, char *argv[])
{
  vector<int> weak{1, 3};
  vector<int> dist{1};

  cout << solution(12, weak, dist) << endl;

  return 0;
}