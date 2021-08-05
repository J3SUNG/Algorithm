#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int DP[1010];

  cin >> n;

  DP[1] = 0;
  DP[2] = 1;
  DP[3] = 0;

  for (int i = 4; i <= n; ++i)
  {
    if (min(DP[i - 1], DP[i - 3]) == 1)
    {
      DP[i] = 0;
    }
    else
    {
      DP[i] = 1;
    }
  }

  if (DP[n] == 1)
  {
    cout << "SK" << endl;
  }
  else
  {
    cout << "CY" << endl;
  }
  return 0;
}