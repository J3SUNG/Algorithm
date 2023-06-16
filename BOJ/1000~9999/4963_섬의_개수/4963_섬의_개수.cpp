#include <iostream>
#include <cstring>
using namespace std;

int w, h;
int c;
int map[60][60];
int mx[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int my[8] = {-1, 0, 1, -1, 1, -1, 0, 1};

void DFS(int a, int b)
{
  map[a][b] = 0;

  for (int i = 0; i < 8; ++i)
  {
    int x = a + mx[i];
    int y = b + my[i];

    if (map[x][y])
    {
      DFS(x, y);
    }
  }
}

int main(int argc, char *argv[])
{
  while (1)
  {
    memset(map, 0, sizeof(map));
    c = 0;

    cin >> w >> h;
    if (!w && !h)
    {
      break;
    }

    for (int i = 1; i <= h; ++i)
    {
      for (int j = 1; j <= w; ++j)
      {
        cin >> map[i][j];
      }
    }

    for (int i = 1; i <= h; ++i)
    {
      for (int j = 1; j <= w; ++j)
      {
        if (map[i][j])
        {
          ++c;
          DFS(i, j);
        }
      }
    }

    cout << c << endl;
  }

  return 0;
}