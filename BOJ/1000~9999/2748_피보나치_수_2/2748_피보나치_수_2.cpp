#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

long long int DP[100];

int main(int argc, char *argv[])
{
  int n;

  memset(DP, 0, sizeof(DP));

  cin >> n;

  DP[1] = 1;

  for (int i = 2; i <= n; ++i)
  {
    DP[i] = DP[i - 1] + DP[i - 2];
  }

  cout << DP[n] << endl;

  return 0;
}