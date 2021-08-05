#include <iostream>
#include <cstring>
using namespace std;

int n, m;
int countNum;
int countYear;
int map[310][310];
int chkMap[310][310];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

void DFS(int a, int b)
{
  chkMap[a][b] = 0;
  for (int k = 0; k < 4; ++k)
  {
    int x = moveX[k] + b;
    int y = moveY[k] + a;
    if (chkMap[y][x] != 0)
    {
      DFS(y, x);
    }
  }
}

void copyMap(int paste[][310], int copy[][310])
{
  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= m; ++j)
    {
      paste[i][j] = copy[i][j];
    }
  }
}

void check(int a, int b)
{
  for (int k = 0; k < 4; ++k)
  {
    int x = moveX[k] + b;
    int y = moveY[k] + a;
    if (map[y][x] == 0 && chkMap[a][b] > 0)
    {
      --chkMap[a][b];
    }
  }
}

int main(int argc, char *argv[])
{
  cin >> n;
  cin >> m;

  memset(map, 0, sizeof(map));
  memset(chkMap, 0, sizeof(chkMap));

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= m; ++j)
    {
      cin >> map[i][j];
      chkMap[i][j] = map[i][j];
    }
  }

  countYear = 0;
  while (1)
  {
    countNum = 0;
    for (int i = 1; i <= n; ++i)
    {
      for (int j = 1; j <= m; ++j)
      {
        if (chkMap[i][j] != 0)
        {
          DFS(i, j);
          ++countNum;
        }
      }
    }

    if (countNum == 0)
    {
      cout << "0" << endl;
      return 0;
    }
    else if (countNum > 1)
    {
      cout << countYear << endl;
      return 0;
    }

    copyMap(chkMap, map);
    for (int i = 1; i <= n; ++i)
    {
      for (int j = 1; j <= m; ++j)
      {
        check(i, j);
      }
    }
    copyMap(map, chkMap);

    ++countYear;
  }

  return 0;
}