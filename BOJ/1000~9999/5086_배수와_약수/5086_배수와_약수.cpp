#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x, y;

  while (1)
  {
    cin >> x >> y;

    if (x == 0 && y == 0)
    {
      break;
    }

    if (y % x == 0)
    {
      cout << "factor" << endl;
    }
    else if (x % y == 0)
    {
      cout << "multiple" << endl;
    }
    else
    {
      cout << "neither" << endl;
    }
  }

  return 0;
}