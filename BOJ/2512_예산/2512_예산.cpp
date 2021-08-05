#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

typedef long long ll;

int n;
int result = 0;
ll sum = 0;
ll budget;
ll leftN, rightN;
ll arr[10001];

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
      temp += x;
    }
    else
    {
      temp += arr[i];
    }

    if (budget < temp)
    {
      rightN = x - 1;
      binary_find((rightN + leftN) / 2);
      return;
    }
  }

  if (sum < temp)
  {
    sum = temp;
    result = x;
  }

  leftN = x + 1;
  binary_find((rightN + leftN) / 2);
}

int main(int argc, char *argv[])
{
  scanf("%lld", &n);

  memset(arr, 0, sizeof(arr));

  for (int i = 0; i < n; ++i)
  {
    scanf("%lld", &arr[i]);
  }
  sort(arr, arr + n);

  scanf("%lld", &budget);

  leftN = 0;
  rightN = arr[n - 1];

  binary_find((leftN + rightN) / 2);

  printf("%d\n", result);

  return 0;
}