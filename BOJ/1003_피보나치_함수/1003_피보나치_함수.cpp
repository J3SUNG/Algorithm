#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;

int main(int argc, char *argv[])
{
  int n;
  int ts;
  ll a, b;
  ll temp;

  cin >> ts;

  while (ts--)
  {
    cin >> n;

    if (n == 0)
    {
      cout << "1 0" << endl;
      continue;
    }
    else if (n == 1)
    {
      cout << "0 1" << endl;
      continue;
    }
    else if (n == 2)
    {
      cout << "1 1" << endl;
      continue;
    }

    a = 1;
    b = 1;

    for (int i = 3; i <= n; ++i)
    {
      temp = a + b;
      a = b;
      b = temp;
    }

    cout << a << " " << b << endl;
  }

  return 0;
}