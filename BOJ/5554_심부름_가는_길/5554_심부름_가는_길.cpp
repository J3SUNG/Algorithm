#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int a, b, c, d;

  cin >> a >> b >> c >> d;

  cout << (a + b + c + d) / 60 << endl;
  cout << (a + b + c + d) % 60 << endl;

  return 0;
}