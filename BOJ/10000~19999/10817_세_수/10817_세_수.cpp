#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x, y, z;
  cin >> x;
  cin >> y;
  cin >> z;
  if (x >= y && y >= z || z >= y && y >= x)
  {
    cout << y << "\n";
  }
  else if (y >= x && x >= z || z >= x && x >= y)
  {
    cout << x << "\n";
  }
  else if (x >= z && z >= y || y >= z && z >= x)
  {
    cout << z << "\n";
  }
  return 0;
}