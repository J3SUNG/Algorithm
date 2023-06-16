#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

typedef long long ll;

int main(int argc, char *argv[])
{
  int n;
  ll DP[100010];

  cin >> n;

  DP[1] = 2;

  for (int i = 2; i <= n; ++i)
  {
    if (i % 2 == 0)
    {
      DP[i] = DP[i - 1];
    }
    else
    {
      DP[i] = (DP[i - 1] * 2) % 16769023;
    }
  }

  cout << DP[n] << endl;

  return 0;
}