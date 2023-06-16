#include <iostream>
#include <cstring>
using namespace std;

int n;
int arr[110];
long long int DP[110][30];

void solve(int x)
{
  if (x == n)
  {
    return;
  }
  for (int i = 0; i <= 20; ++i)
  {
    if (DP[x - 1][i] != 0)
    {
      if (i + arr[x] <= 20)
      {
        DP[x][i + arr[x]] += DP[x - 1][i];
      }
      if (i - arr[x] >= 0)
      {
        DP[x][i - arr[x]] += DP[x - 1][i];
      }
    }
  }
}

int main(int argc, char *argv[])
{
  int sum = 0;
  memset(arr, 0, sizeof(arr));

  cin >> n;

  for (int i = 1; i <= n; ++i)
  {
    cin >> arr[i];
  }

  DP[1][arr[1]] = 1;

  for (int i = 2; i <= n; ++i)
  {
    solve(i);
  }

  cout << DP[n - 1][arr[n]] << endl;

  return 0;
}