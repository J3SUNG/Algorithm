#include <iostream>
#define MOD 1000000000
#define MAX_BIT 1024
typedef long long ll;
using namespace std;

ll dp[101][10][MAX_BIT];

void solution()
{
  int n = 0;
  int bit = 0;
  ll result = 0;

  cin >> n;

  for (int i = 1; i < 10; ++i)
  {
    dp[1][i][1 << i] = 1;
  }

  for (int i = 2; i <= n; ++i)
  {
    for (int j = 0; j < 10; ++j)
    {
      for (int k = 0; k < MAX_BIT; ++k)
      {
        bit = k | (1 << j);
        dp[i][j][bit] = (dp[i][j][bit] + (j == 0 ? 0 : dp[i - 1][j - 1][k]) + (j == 9 ? 0 : dp[i - 1][j + 1][k])) % MOD;
      }
    }
  }

  for (int i = 0; i < 10; ++i)
  {
    result = (result + dp[n][i][MAX_BIT - 1]) % MOD;
  }

  cout << result << endl;
}

int main(int argc, char *argv[])
{
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  solution();

  return 0;
}