#include <iostream>
#include <cstring>
using namespace std;

int arr[2010];
int DP[2010][2010];

int main(int argc, char *argv[])
{
  int n;

  cin >> n;

  memset(arr, 0, sizeof(arr));
  memset(DP, 0, sizeof(DP));

  for (int i = 1; i <= n; ++i)
  {
    scanf("%d", &arr[i]);
  }

  for (int i = 1; i <= n; i++)
  {
    DP[i][i] = 1;
    if (arr[i] == arr[i - 1])
    {
      DP[i - 1][i] = 1;
    }
  }

  for (int i = 2; i < n; i++)
  {
    for (int j = 1; j <= n - i; j++)
    {
      int k = i + j;
      if (arr[j] == arr[k] && DP[j + 1][k - 1] == 1)
        DP[j][k] = 1;
    }
  }

  int q;
  scanf("%d", &q);

  for (int i = 0; i < q; ++i)
  {
    int x, y;
    scanf("%d %d", &x, &y);
    printf("%d\n", DP[x][y]);
  }

  return 0;
}