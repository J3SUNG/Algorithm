#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int n;
int map[110][110];
int dis[110][110];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

void init()
{
  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (map[i][j] == 0)
      {
        dis[i][j] = 987654321;
      }
    }
  }
}

void DFS(int a, int b, int c)
{
  if (map[a][b] == 1)
  {
    map[a][b] = c;
    dis[a][b] = 0;
    for (int l = 0; l < 4; ++l)
    {
      int x = moveX[l] + a;
      int y = moveY[l] + b;
      if (x >= 0 && y >= 0 && x < n && y < n)
      {
        DFS(x, y, c);
      }
    }
  }
}

int BFS(int a, int b, int c)
{
  int count;
  int minDis = 987654321;

  queue<int> q1;
  queue<int> q2;
  q1.push(a);
  q2.push(b);

  while (!q1.empty())
  {
    int qX = q1.front();
    int qY = q2.front();
    q1.pop();
    q2.pop();

    for (int l = 0; l < 4; ++l)
    {
      int x = moveX[l] + qX;
      int y = moveY[l] + qY;

      if (x >= 0 && y >= 0 && x < n && y < n)
      {
        if (map[x][y] > 0 && c != map[x][y])
        {
          minDis = min(minDis, dis[qX][qY]);
          continue;
        }

        if (map[x][y] == 0 && dis[x][y] > dis[qX][qY] + 1)
        {
          dis[x][y] = dis[qX][qY] + 1;
          q1.push(x);
          q2.push(y);
        }
      }
    }
  }
  return minDis;
}

int main(int argc, char *argv[])
{
  memset(map, 0, sizeof(map));
  memset(dis, 0, sizeof(dis));
  int count = 2;
  int minN = 987654321;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      cin >> map[i][j];
      dis[i][j] = 987654321;
    }
  }

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (map[i][j] == 1)
      {
        DFS(i, j, count);
        count++;
      }
    }
  }

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (map[i][j] > 1)
      {
        init();
        minN = min(minN, BFS(i, j, map[i][j]));
      }
    }
  }

  cout << minN << endl;

  return 0;
}