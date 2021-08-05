#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

typedef long long ll;

int main(int argc, char *argv[])
{
  ll n;
  ll x;
  ll y;
  ll result = 0;

  cin >> n;
  n %= 1500000;

  x = 0;
  y = 1;

  if (n == 1)
  {
    result = 1;
  }

  for (int i = 2; i <= n; ++i)
  {
    result = (x + y) % 1000000;
    x = y;
    y = result;
  }

  cout << result << endl;

  return 0;
}