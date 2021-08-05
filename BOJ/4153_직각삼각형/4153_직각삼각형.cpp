#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <cmath>
#define fio ios_base::sync_with_stdio(0), cin.tie(0)
using namespace std;

int main(int argc, char *argv[])
{
  int side[3];

  while (1)
  {
    cin >> side[0];
    cin >> side[1];
    cin >> side[2];

    if (side[0] == 0 && side[1] == 0 && side[2] == 0)
    {
      break;
    }

    sort(side, side + 3);

    if (pow(side[2], 2) == pow(side[0], 2) + pow(side[1], 2))
    {
      cout << "right" << endl;
    }
    else
    {
      cout << "wrong" << endl;
    }
  }

  return 0;
}