#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int DP[50][2];

  cin >> n;

  DP[0][0] = 0;
  DP[0][1] = 0;
  DP[1][0] = 0;
  DP[1][1] = 1;
  DP[2][0] = 1;
  DP[2][1] = 1;

  for (int i = 3; i <= n; ++i)
  {
    DP[i][0] = DP[i - 1][0] + DP[i - 2][0];
    DP[i][1] = DP[i - 1][1] + DP[i - 2][1];
  }

  cout << DP[n][0] << " " << DP[n][1] << endl;

  return 0;
}