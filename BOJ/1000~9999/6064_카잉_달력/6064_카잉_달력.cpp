#include <iostream>
#include <cstring>
using namespace std;

void printResult(int x)
{
  if (x != 0)
  {
    cout << x << endl;
  }
  else
  {
    cout << "-1" << endl;
  }
}

int gcd(int a, int b)
{
  int c;
  while (b != 0)
  {
    c = a % b;
    a = b;
    b = c;
  }

  return a;
}

int lcm(int a, int b)
{
  return a * b / gcd(a, b);
}

int main(int argc, char *argv[])
{
  int testcase;
  int m, n, x, y;
  int endDay;
  int count;

  cin >> testcase;

  while (testcase--)
  {
    count = 0;

    cin >> m >> n >> x >> y;

    endDay = lcm(m, n);

    for (int i = 0; (m * i) + x <= endDay; ++i)
    {
      int t = ((m * i) + x) % n;
      if (t == 0)
      {
        t = n;
      }

      if (t == y)
      {
        count = (m * i) + x;
        break;
      }
    }

    printResult(count);
  }

  return 0;
}