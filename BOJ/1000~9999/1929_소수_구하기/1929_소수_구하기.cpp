#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int arr[1000010];

int main(int argc, char *argv[])
{
  int m, n;

  cin >> m >> n;

  memset(arr, 0, sizeof(arr));

  arr[0] = 1;
  arr[1] = 1;
  for (int i = 2; i <= n; ++i)
  {
    if (arr[i] == 1)
    {
      continue;
    }
    for (int j = i * 2; j <= n; j += i)
    {
      arr[j] = 1;
    }
  }

  for (int i = m; i <= n; ++i)
  {
    if (arr[i] == 0)
    {
      printf("%d\n", i);
    }
  }

  return 0;
}