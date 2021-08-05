#include <iostream>
#include <cstring>
using namespace std;

long long int DP[10010];

int main(int argc, char *argv[])
{
  int ts;
  int checkPoint = 3;

  cin >> ts;

  memset(DP, 0, sizeof(DP));

  DP[0] = 1;
  DP[1] = 1;
  DP[2] = 2;
  DP[3] = 4;

  while (ts--)
  {
    int n;

    cin >> n;

    if (DP[n])
    {
      cout << DP[n] << endl;
      continue;
    }

    for (int i = checkPoint + 1; i <= n; ++i)
    {
      DP[i] = DP[i - 1] + DP[i - 2] + DP[i - 3] + DP[i - 4];
    }
    cout << DP[n] << endl;
    checkPoint = n;
  }

  return 0;
}