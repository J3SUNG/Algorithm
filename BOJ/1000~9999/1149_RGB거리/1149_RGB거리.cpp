#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int memo[1000][3];
  int n;
  int minMemo = 987654321;
  cin >> n;
  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < 3; ++j)
    {
      memo[i][j] = 0;
      cin >> memo[i][j];
    }
  }
  for (int i = 1; i < n; ++i)
  {
    memo[i][0] += min(memo[i - 1][1], memo[i - 1][2]);
    memo[i][1] += min(memo[i - 1][0], memo[i - 1][2]);
    memo[i][2] += min(memo[i - 1][0], memo[i - 1][1]);
  }
  for (int i = 0; i < 3; ++i)
  {
    if (minMemo > memo[n - 1][i])
    {
      minMemo = memo[n - 1][i];
    }
  }

  cout << minMemo;
  return 0;
}