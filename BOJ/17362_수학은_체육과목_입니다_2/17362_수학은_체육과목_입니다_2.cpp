#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int x;
  cin >> x;

  if (x % 2 == 0)
  {
    x /= 4;

    if (x % 2 == 0)
    {
      cout << "2" << endl;
    }
    else
    {
      cout << "4" << endl;
    }
  }
  else
  {
    x /= 2;
    if (x % 2 == 1)
    {
      cout << "3" << endl;
    }
    else
    {
      x /= 2;
      if (x % 2 == 1)
      {
        cout << "5" << endl;
      }
      else
      {
        cout << "1" << endl;
      }
    }
  }

  return 0;
}