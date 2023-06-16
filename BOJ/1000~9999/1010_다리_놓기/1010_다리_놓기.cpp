#include <iostream>
using namespace std;

int DP[40][40];
int west, east;

void init()
{
  for (int i = 0; i < 40; ++i)
  {
    for (int j = 0; j < 40; ++j)
    {
      DP[i][j] = 0;
    }
  }
}

int func(int x, int y, int last)
{
  if (DP[x + 1][y + 1] != 0)
  {
    if (y == last)
    {
      DP[x][y] = DP[x + 1][y + 1];
      return DP[x][y];
    }
    DP[x][y] += func(x, y + 1, last) + DP[x + 1][y + 1];
  }
  else
  {
    if (y == last)
    {
      DP[x][y] = 1;
      return DP[x][y];
    }
    DP[x][y] += func(x, y + 1, last) + 1;
  }
  return DP[x][y];
}

int main(int argc, char *argv[])
{
  int cycle;
  cin >> cycle;

  while (cycle != 0)
  {
    init();
    cin >> west >> east;
    int last = east;
    int start = west;

    for (int i = west; i > 0; --i)
    {
      DP[i][i] = func(start, start, last);
      last--;
      start--;
    }

    cout << DP[1][1] << endl;
    --cycle;
  }

  return 0;
}