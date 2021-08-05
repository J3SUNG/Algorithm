#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int a, b;
  int x, y;
  int result;

  cin >> x >> y;

  b = y;
  a = y - x;

  if (x == y)
  {
    cout << "0 0" << endl;
  }
  else
  {
    int i = 1;
    while (++i)
    {
      if (a < i)
      {
        break;
      }
      if (a % i == 0 && b % i == 0)
      {
        a /= i;
        b /= i;
        --i;
      }
    }

    cout << a << " " << b << endl;
  }

  return 0;
}