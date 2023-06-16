#include <iostream>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int t;

  while (1)
  {
    int x, y;

    cin >> x >> y;

    if (x == 0 && y == 0)
    {
      break;
    }

    cout << x + y << endl;
  }

  return 0;
}