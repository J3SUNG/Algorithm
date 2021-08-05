#include <iostream>
using namespace std;

char map[3000][3000];

void init()
{
  for (int i = 0; i < 3000; ++i)
  {
    for (int j = 0; j < 3000; ++j)
    {
      map[i][j] = ' ';
    }
  }
}

void solve(int n, int x, int y)
{
  if (n == 1)
  {
    map[x][y] = '*';
    return;
  }
  int div = n / 3;
  for (int i = 0; i < 3; ++i)
  {
    for (int j = 0; j < 3; ++j)
    {
      if (i == 1 && j == 1)
      {
        continue;
      }
      solve(div, x + (div * i), y + (div * j));
    }
  }
  return;
}

int main(int argc, char *argv[])
{
  int n;
  cin >> n;

  init();
  solve(n, 0, 0);

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      cout << map[i][j];
    }
    cout << endl;
  }

  return 0;
}