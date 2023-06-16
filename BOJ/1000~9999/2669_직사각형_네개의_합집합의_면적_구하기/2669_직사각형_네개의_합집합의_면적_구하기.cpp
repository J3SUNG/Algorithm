#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int xs, xe, ys, ye;
  int count = 0;
  int map[110][110];

  memset(map, 0, sizeof(map));

  for (int i = 0; i < 4; ++i)
  {
    cin >> xs >> ys >> xe >> ye;
    for (int j = xs; j < xe; ++j)
    {
      for (int k = ys; k < ye; ++k)
      {
        map[j][k] = 1;
      }
    }
  }

  for (int i = 1; i <= 100; ++i)
  {
    for (int j = 1; j <= 100; ++j)
    {
      if (map[i][j] == 1)
      {
        ++count;
      }
    }
  }

  cout << count << endl;

  return 0;
}