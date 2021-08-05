#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int ts;
  int n;
  long long result = 0;
  long long DP[10];

  cin >> ts;

  while (ts--)
  {
    result = 0;

    cin >> n;

    fill(DP, DP + 10, 1);
    DP[0] = 0;

    for (int i = 2; i <= n; ++i)
    {
      DP[1] = DP[1] + 1;
      for (int j = 2; j <= 9; ++j)
      {
        DP[j] = DP[j - 1] + DP[j];
      }
    }

    for (int i = 0; i <= 9; ++i)
    {
      result += DP[i];
    }

    cout << result + 1 << endl;
  }

  return 0;
}