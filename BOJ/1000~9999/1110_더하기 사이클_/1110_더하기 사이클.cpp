#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x;
  int a, b, c, d;
  int count = 0;
  cin >> x;
  d = x;
  while (d != x || count == 0)
  {
    a = d / 10;
    b = d % 10;
    c = (a + b) % 10;
    a = b;
    b = c;
    d = a * 10 + b;
    count++;
  }
  cout << count << "\n";
  return 0;
}