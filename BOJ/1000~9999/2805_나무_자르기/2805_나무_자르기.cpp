#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

typedef long long ll;

int n, m;
int result = 0;
ll sum = 9876543210;
ll leftN, rightN;
ll arr[1000001];

void binary_find(ll x)
{
  ll temp = 0;

  if (leftN > rightN)
  {
    return;
  }

  for (int i = 0; i < n; ++i)
  {
    if (arr[i] > x)
    {
      temp += arr[i] - x;
    }
  }

  if (m > temp)
  {
    rightN = x - 1;
    binary_find((rightN + leftN) / 2);
    return;
  }
  else
  {
    if (sum >= temp)
    {
      sum = temp;
      result = x;
    }
  }

  leftN = x + 1;
  binary_find((rightN + leftN) / 2);
}

int main(int argc, char *argv[])
{
  scanf("%d", &n);
  scanf("%d", &m);

  memset(arr, 0, sizeof(arr));

  for (int i = 0; i < n; ++i)
  {
    scanf("%lld", &arr[i]);
  }
  sort(arr, arr + n);

  leftN = 0;
  rightN = arr[n - 1];

  binary_find((leftN + rightN) / 2);

  printf("%d\n", result);

  return 0;
}