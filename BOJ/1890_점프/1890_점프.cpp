#include <iostream>
using namespace std;

void solve()
{
  int map[110][110];
  long long int memo[110][110];
  int n;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      memo[i][j] = 0;
      cin >> map[i][j];
    }
  }
  memo[0][0] = 1;

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      int x = i + map[i][j];
      int y = j + map[i][j];

      if (memo[i][j] == 0)
      {
        continue;
      }
      if (i == n - 1 && j == n - 1)
      {
        break;
      }

      if (x < n)
      {
        memo[x][j] += memo[i][j];
      }
      if (y < n)
      {
        memo[i][y] += memo[i][j];
      }
    }
  }
  cout << memo[n - 1][n - 1] << endl;
}

int main(int argc, char *argv[])
{
  solve();

  return 0;
}