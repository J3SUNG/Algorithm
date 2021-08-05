#include <iostream>
#include <algorithm>
using namespace std;

int DP[3][100010];

int main(int argc, char *argv[])
{
  int n;
  int sum = 0;
  cin >> n;

  for (int i = 0; i < 100010; ++i)
  {
    DP[0][i] = 0;
    DP[1][i] = 0;
    DP[2][i] = 0;
  }

  DP[0][1] = 1;
  DP[1][1] = 1;
  DP[2][1] = 1;

  for (int i = 2; i <= n; ++i)
  {
    DP[0][i] = (DP[1][i - 1] + DP[2][i - 1]) % 9901;
    DP[1][i] = (DP[0][i - 1] + DP[2][i - 1]) % 9901;
    DP[2][i] = (DP[0][i - 1] + DP[1][i - 1] + DP[2][i - 1]) % 9901;
  }

  sum = (DP[0][n] + DP[1][n] + DP[2][n]) % 9901;
  cout << sum;

  return 0;
}