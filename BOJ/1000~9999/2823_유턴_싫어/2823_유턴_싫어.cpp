#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
bool clear[20][20];
char map[20][20];
int visit[20][20];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

void copy()
{
  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < m; ++j)
    {
      if (visit[i][j] > 0)
      {
        clear[i][j] = true;
      }
    }
  }
}

bool DFS(int a, int b, int sy, int sx, int py, int px)
{
  if (clear[a][b] || (a == sy && b == sx && visit[a][b] == 1))
  {
    return true;
  }
  for (int i = 0; i < 4; ++i)
  {
    int x = b + moveX[i];
    int y = a + moveY[i];

    if (map[y][x] != '.' || visit[y][x] == 2 || (x == px && y == py))
    {
      continue;
    }

    ++visit[y][x];
    if (DFS(y, x, sy, sx, a, b))
    {
      return true;
    }
    --visit[y][x];
  }

  return false;
}

int main(int argc, char *argv[])
{
  int c;
  string s;

  memset(map, ' ', sizeof(map));
  memset(clear, false, sizeof(clear));

  cin >> n >> m;

  for (int i = 1; i <= n; ++i)
  {
    cin >> s;
    for (int j = 1; j <= m; ++j)
    {
      map[i][j] = s[j - 1];
    }
  }

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= m; ++j)
    {
      if (map[i][j] != '.')
      {
        continue;
      }

      c = 0;
      for (int k = 0; k < 4; ++k)
      {
        int x = j + moveX[k];
        int y = i + moveY[k];

        if (map[y][x] != '.')
        {
          continue;
        }

        memset(visit, 0, sizeof(visit));

        if (clear[i][j])
        {
          ++c;
          continue;
        }

        if (DFS(i, j, i, j, i, j))
        {
          ++c;

          if (c > 1)
          {
            copy();
            break;
          }
        }
      }
      if (c < 2)
      {
        cout << "1" << endl;
        return 0;
      }
    }
  }

  printf("0\n");

  return 0;
}