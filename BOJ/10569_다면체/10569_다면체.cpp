#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int ts;
  int x, y;
  int z;

  cin >> ts;

  while (ts--)
  {
    cin >> x >> y;
    z = x - 2 - y;
    z *= -1;

    cout << z << endl;
  }

  return 0;
}