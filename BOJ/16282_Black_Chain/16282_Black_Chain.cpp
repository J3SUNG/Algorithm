#include <iostream>
#include <algorithm>
using namespace std;

typedef long long ll;

int main(int argc, char *argv[])
{
  int i = 2;
  ll n;
  ll num = 2;
  ll sum;

  cin >> n;

  while (1)
  {
    num *= 2;
    sum = num * i - 1;

    if (sum >= n)
    {
      --i;
      break;
    }
    ++i;
  }

  cout << i << "\n";

  return 0;
}