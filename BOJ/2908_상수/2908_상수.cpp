#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int a, b;
  cin >> a;
  cin >> b;

  a = a / 100 + ((a - a / 100 * 100) / 10) * 10 + (a - a / 10 * 10) * 100;
  b = b / 100 + ((b - b / 100 * 100) / 10) * 10 + (b - b / 10 * 10) * 100;
  if (a > b)
  {
    cout << a << endl;
  }
  else
  {
    cout << b << endl;
  }

  return 0;
}