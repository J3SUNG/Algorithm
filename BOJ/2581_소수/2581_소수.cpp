#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int arr[10010];

int main(int argc, char *argv[])
{
  int m, n;
  int sum = 0;
  int flag = 0;
  int first = 0;

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
    if (flag == 0 && arr[i] == 0)
    {
      first = i;
      flag = 1;
    }
    if (arr[i] == 0)
    {
      sum += i;
    }
  }

  if (sum == 0)
  {
    cout << "-1" << endl;
    return 0;
  }

  cout << sum << endl;
  cout << first << endl;

  return 0;
}