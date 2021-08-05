#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int n;
int maxHeight = 0;
int maxCount = 1;
int map[110][110];
int visit[110][110];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

void DFS(int a, int b)
{
  int y, x;
  visit[a][b] = 1;

  for (int i = 0; i < 4; ++i)
  {
    y = moveY[i] + a;
    x = moveX[i] + b;
    if (!visit[y][x] && map[y][x])
    {
      DFS(y, x);
    }
  }
}

int main(int argc, char *argv[])
{
  int count = 0;

  cin >> n;

  memset(map, 0, sizeof(map));

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= n; ++j)
    {
      cin >> map[i][j];
      maxHeight = max(maxHeight, map[i][j]);
    }
  }

  for (int k = 1; k < maxHeight; ++k)
  {
    count = 0;
    memset(visit, 0, sizeof(visit));

    for (int i = 1; i <= n; ++i)
    {
      for (int j = 1; j <= n; ++j)
      {
        if (map[i][j] <= k)
        {
          map[i][j] = 0;
        }
      }
    }
    for (int i = 1; i <= n; ++i)
    {
      for (int j = 1; j <= n; ++j)
      {
        if (map[i][j] && !visit[i][j])
        {
          DFS(i, j);
          ++count;
        }
      }
    }
    maxCount = max(maxCount, count);
  }

  cout << maxCount << endl;

  return 0;
}