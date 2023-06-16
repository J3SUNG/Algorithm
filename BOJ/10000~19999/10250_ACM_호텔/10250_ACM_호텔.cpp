#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int testcase;
  int h, w, n;
  int x, y;

  cin >> testcase;

  while (testcase--)
  {
    cin >> h;
    cin >> w;
    cin >> n;

    x = n % h;
    y = n / h + 1;

    if (x == 0)
    {
      x = h;
    }
    if (!(n % h))
    {
      y -= 1;
    }

    cout << x * 100 + y << endl;
  }

  return 0;
}