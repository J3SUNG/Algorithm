#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int a;
  int count = 0;
  cin >> a;
  while (a > 0)
  {
    if (a % 3 == 0 && a >= 15)
    {
      a -= 15;
      count += 3;
    }
    else if (a % 3 == 1 && a >= 10)
    {
      a -= 10;
      count += 2;
    }
    else if (a % 3 == 2 && a >= 5)
    {
      a -= 5;
      count += 1;
    }
    else if (a % 3 == 0)
    {
      count += (a / 3);
      a = 0;
    }
    else
    {
      break;
    }
  }
  if (a == 0)
  {
    cout << count << endl;
  }
  else
  {
    cout << "-1" << endl;
  }

  return 0;
}