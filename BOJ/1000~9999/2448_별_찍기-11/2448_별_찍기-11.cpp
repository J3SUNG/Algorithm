#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

char DB[3][6] =
    {"  *  ",
     " * * ",
     "*****"};
char map[4000][8000];

void solve(int n, int y, int x)
{
  if (n == 1)
  {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 5; j++)
        map[y + i][x + j] = DB[i][j];
    return;
  }
  solve(n / 2, y, x + 3 * n / 2);
  solve(n / 2, y + 3 * n / 2, x);
  solve(n / 2, y + 3 * n / 2, x + 3 * n);
}

int main(int argc, char *argv[])
{
  int n;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n * 2; ++j)
    {
      map[i][j] = ' ';
    }
  }

  solve(n / 3, 0, 0);

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n * 2; ++j)
    {
      cout << map[i][j];
    }
    cout << endl;
  }

  return 0;
}