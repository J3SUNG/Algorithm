#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

bool compare(pair<int, double> a, pair<int, double> b)
{
  if (a.second == b.second)
  {
    return a.first < b.first;
  }
  else
  {
    return a.second > b.second;
  }
}

vector<int> solution(int num, vector<int> stages)
{
  double resolve = 0.0;
  double unresolve = 0.0;
  int index = 0;
  vector<int> answer;
  vector<pair<int, double>> result;

  sort(stages.begin(), stages.end(), greater<>());

  for (int i = num; i > 0; --i)
  {
    while (i <= stages[index] && index < stages.size())
    {
      resolve += 1.0;
      if (i == stages[index])
      {
        unresolve += 1.0;
      }
      ++index;
    }
    if (unresolve == 0.0)
    {
      result.push_back(make_pair(i, 0));
    }
    else
    {
      result.push_back(make_pair(i, unresolve / resolve));
    }
    unresolve = 0.0;
  }

  sort(result.begin(), result.end(), compare);

  for (int i = 0; i < result.size(); ++i)
  {
    answer.push_back(result[i].first);
  }

  return answer;
}

int main(int argc, char *argv[])
{
  int n;
  vector<int> stages;

  n = 5;
  stages = {2, 1, 2, 6, 2, 4, 3, 3};

  solution(n, stages);

  return 0;
}