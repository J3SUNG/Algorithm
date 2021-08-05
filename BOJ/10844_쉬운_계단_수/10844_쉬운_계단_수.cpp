#include <iostream>
#include <algorithm>
using namespace std;

int memo[110][10];

int main(int argc, char *argv[])
{
  int n;
  int result = 0;
  cin >> n;
  memo[1][0] = 0;
  memo[1][1] = 1;
  memo[1][2] = 1;
  memo[1][3] = 1;
  memo[1][4] = 1;
  memo[1][5] = 1;
  memo[1][6] = 1;
  memo[1][7] = 1;
  memo[1][8] = 1;
  memo[1][9] = 1;

  for (int i = 2; i <= n; ++i)
  {
    for (int j = 0; j <= 9; ++j)
    {
      if (j == 0)
      {
        memo[i][j] += memo[i - 1][1] % 1000000000;
      }
      else if (j == 9)
      {
        memo[i][j] += memo[i - 1][8] % 1000000000;
      }
      else
      {
        memo[i][j] = (memo[i - 1][j + 1] + memo[i - 1][j - 1]) % 1000000000;
      }
    }
  }
  for (int i = 0; i <= 9; ++i)
  {
    result += memo[n][i];
    result %= 1000000000;
  }

  cout << result;
  return 0;
}