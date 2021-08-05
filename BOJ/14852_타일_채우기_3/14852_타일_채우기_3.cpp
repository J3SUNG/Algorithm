#include <iostream>
#define MOD 1000000007
typedef long long ll;
using namespace std;

ll DP[1000001][2];

void solution()
{
  int n;

  cin >> n;

  DP[0][0] = 0;
  DP[1][0] = 2;
  DP[2][0] = 7;
  DP[2][1] = 1;

  for (int i = 3; i <= n; ++i)
  {
    DP[i][1] = (DP[i - 3][0] + DP[i - 1][1]) % MOD;
    DP[i][0] = (DP[i][1] * 2 + DP[i - 1][0] * 2 + DP[i - 2][0] * 3) % MOD;
  }

  cout << DP[n][0] << endl;
}

int main(int argc, char *argv[])
{
  solution();

  return 0;
}