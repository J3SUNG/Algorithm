#include <iostream>
#include <algorithm>
#include <string>
#include <cstring>
using namespace std;

int DP[1000010];

int main(int argc, char *argv[])
{
  int n;

  memset(DP, 0, sizeof(DP));

  DP[1] = 1;
  DP[2] = 2;

  cin >> n;

  for (int i = 3; i <= n; ++i)
  {
    DP[i] = (DP[i - 1] + DP[i - 2]) % 15746;
  }

  cout << DP[n] << endl;

  return 0;
}