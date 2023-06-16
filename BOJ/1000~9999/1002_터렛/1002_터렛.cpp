#include <iostream>
#include <cmath>
using namespace std;

int main(int argc, char *argv[])
{
  double d;
  int ts;
  int x1, x2, y1, y2, r1, r2;

  cin >> ts;

  while (ts--)
  {
    cin >> x1;
    cin >> y1;
    cin >> r1;
    cin >> x2;
    cin >> y2;
    cin >> r2;

    d = sqrt(pow(x1 - x2, 2.0) + pow(y1 - y2, 2.0));

    if (x1 == x2 && y1 == y2)
    {
      if (r1 == r2)
      {
        cout << "-1";
      }
      else
      {
        cout << "0";
      }
    }
    else
    {
      if ((r1 + r2) > d && abs(r1 - r2) < d)
      {
        cout << "2";
      }
      else if ((r1 + r2) == d || abs(r1 - r2) == d)
      {
        cout << "1";
      }
      else
      {
        cout << "0";
      }
    }
    cout << "\n";
  }

  return 0;
}