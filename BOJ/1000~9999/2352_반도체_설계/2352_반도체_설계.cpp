#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n = 0;
  int len = 1;
  int arr[40010];
  int DP[40010] = {0};
  scanf("%d", &n);

  for (int i = 1; i <= n; ++i)
  {
    scanf("%d", &arr[i]);
  }

  DP[len] = arr[1];

  for (int i = 2; i <= n; ++i)
  {
    if (DP[len] < arr[i])
    {
      DP[++len] = arr[i];
    }
    else
    {
      int index = lower_bound(DP + 1, DP + len + 1, arr[i]) - DP;
      DP[index] = arr[i];
    }
  }

  printf("%d\n", len);

  return 0;
}