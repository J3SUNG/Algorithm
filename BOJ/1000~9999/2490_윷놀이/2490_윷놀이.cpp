#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int sum;
  int cycle = 3;
  int a, b, c, d;

  while (cycle--)
  {
    cin >> a >> b >> c >> d;

    sum = a + b + c + d;

    switch (sum)
    {
    case 0:
      cout << "D" << endl;
      break;
    case 1:
      cout << "C" << endl;
      break;
    case 2:
      cout << "B" << endl;
      break;
    case 3:
      cout << "A" << endl;
      break;
    case 4:
      cout << "E" << endl;
      break;
    }
  }

  return 0;
}