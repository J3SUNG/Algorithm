#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

int h;
int n, m;
int result = -1;
int visit[210][210];
int map[210][210];
int monkey[4][2] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
int horse[8][2] = {{2, 1}, {1, 2}, {2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {-2, -1}, {-1, -2}};
queue<pair<pair<int, int>, pair<int, int>>> q; // y좌표, x좌표, 현재 동작수, 나이트 동작수

void BFS()
{
  int a, b;

  visit[2][2] = 1;
  q.push(make_pair(make_pair(2, 2), make_pair(0, 0)));

  while (!q.empty())
  {
    int a = q.front().first.first;
    int b = q.front().first.second;
    int c = q.front().second.first;
    int d = q.front().second.second;

    q.pop();

    if (a == n + 1 && b == m + 1)
    {
      result = c;
      return;
    }

    for (int i = 0; i < 8; ++i)
    {
      int y = a + horse[i][0];
      int x = b + horse[i][1];

      if (map[y][x] == 0 && visit[y][x] > d + 1 && d < h)
      {
        visit[y][x] = d + 1;
        q.push(make_pair(make_pair(y, x), make_pair(c + 1, d + 1)));
      }
    }

    for (int i = 0; i < 4; ++i)
    {
      int y = a + monkey[i][0];
      int x = b + monkey[i][1];

      if (map[y][x] == 0 && visit[y][x] > d)
      {
        visit[y][x] = d;
        q.push(make_pair(make_pair(y, x), make_pair(c + 1, d)));
      }
    }
  }
}

int main(int argc, char *argv[])
{
  memset(map, -1, sizeof(map));

  for (int i = 0; i < 210; ++i)
  {
    for (int j = 0; j < 210; ++j)
    {
      visit[i][j] = 100;
    }
  }

  scanf("%d", &h);
  scanf("%d", &m);
  scanf("%d", &n);

  for (int i = 2; i <= n + 1; ++i)
  {
    for (int j = 2; j <= m + 1; ++j)
    {
      scanf("%d", &map[i][j]);
    }
  }

  BFS();

  printf("%d\n", result);

  return 0;
}