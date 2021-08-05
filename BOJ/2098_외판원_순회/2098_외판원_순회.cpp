#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#define MAX_BIT 65536
#define INF 987654321
using namespace std;

int n;
int cost[16][MAX_BIT];
vector<vector<int>> v;

void input()
{
  int num;
  vector<int> temp;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      cin >> num;
      temp.push_back(num);
    }
    v.push_back(temp);
    temp.clear();
  }
}

int solve(int location, int visitState)
{
  if (visitState == (1 << n) - 1)
  {
    return v[location][0] ? v[location][0] : INF;
  }

  int &ret = cost[location][visitState];
  if (ret != -1)
  {
    return ret;
  }

  ret = INF;
  for (int i = 0; i < n; ++i)
  {
    if (visitState & (1 << i))
    {
      continue;
    }
    if (v[location][i] == 0)
    {
      continue;
    }

    ret = min(ret, solve(i, visitState | (1 << i)) + v[location][i]);
  }

  return ret;
}

void solution()
{
  memset(cost, -1, sizeof(cost));

  cout << solve(0, 1) << endl;
}

int main(int argc, char *argv[])
{
  input();
  solution();

  return 0;
}