#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int num;
  int count = 0;
  vector<int> v;

  while (1)
  {
    cin >> num;

    if (num == -1)
    {
      break;
    }
    if (num == 0)
    {
      for (int i = 0; i < v.size(); ++i)
      {
        for (int j = 0; j < v.size(); ++j)
        {
          if (v[j] * 2 == v[i])
          {
            ++count;
          }
        }
      }
      cout << count << endl;
      count = 0;
      v.clear();
    }
    else
    {
      v.push_back(num);
    }
  }

  return 0;
}