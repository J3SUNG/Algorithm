#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x, y;
  int a, b, c, d;

  cin >> x;
  cin >> y;

  a = x * (y % 10);
  cout << a << endl;
  y /= 10;
  b = x * (y % 10);
  cout << b << endl;
  y /= 10;
  c = x * y;
  cout << c << endl;
  d = (a + (b * 10 + (c * 100)));
  cout << d << endl;

  return 0;
}