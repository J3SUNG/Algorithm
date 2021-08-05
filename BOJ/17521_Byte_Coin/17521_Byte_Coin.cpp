#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

typedef long long ll;

int main(int argc, char *argv[])
{
  ll n, w;
  ll x;
  ll arr[20];

  cin >> n >> w;

  for (int i = 0; i < n; ++i)
  {
    cin >> arr[i];
  }

  for (int i = 0; i < n - 1; ++i)
  {

    if (arr[i] < arr[i + 1])
    {
      x = w / arr[i];
      w = w % arr[i];
      x = arr[i + 1] * x;
      w += x;
    }
  }

  cout << w << endl;

  return 0;
}