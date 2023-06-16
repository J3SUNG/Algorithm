#include <iostream>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int N;
  int K;
  int mod = 1000000000;
  int memo[210][210];
  memset(memo, 0, sizeof(memo));

  cin >> N;
  cin >> K;

  for (int i = 0; i <= N; ++i)
  {
    memo[1][i] = 1;
  }

  for (int i = 2; i <= K; ++i)
  {
    for (int j = 0; j <= N; ++j)
    {
      for (int l = 0; l <= j; ++l)
      {
        memo[i][j] += memo[i - 1][l];
        memo[i][j] %= mod;
      }
    }
  }

  cout << memo[K][N] << endl;

  return 0;
}