#include <iostream>
#include <cstring>
#include <string>
#include <queue>
#include <algorithm>
#define MAX 987654321
using namespace std;

int main(int argc, char *argv[])
{
  bool flag = false;
  int answer = 0;
  int L, R, C;
  int sz, sy, sx;
  int ez, ey, ex;
  int move[6][3] = {{0, 0, 1}, {0, 1, 0}, {1, 0, 0}, {0, 0, -1}, {0, -1, 0}, {-1, 0, 0}};
  bool visit[32][32][32];
  char map[32][32][32];
  queue<pair<pair<int, int>, pair<int, int>>> q;

  while (1)
  {
    cin >> L >> R >> C;

    if (L == 0 && R == 0 && C == 0)
    {
      break;
    }

    flag = false;
    memset(visit, false, sizeof(visit));
    memset(map, '#', sizeof(map));

    while (!q.empty())
    {
      q.pop();
    }

    for (int i = 1; i <= L; ++i)
    {
      for (int j = 1; j <= R; ++j)
      {
        for (int k = 1; k <= C; ++k)
        {
          cin >> map[i][j][k];

          if (map[i][j][k] == 'S')
          {
            sz = i;
            sy = j;
            sx = k;
          }
          else if (map[i][j][k] == 'E')
          {
            ez = i;
            ey = j;
            ex = k;
          }
        }
      }
    }

    q.push(make_pair(make_pair(sz, sy), make_pair(sx, 0)));

    while (!q.empty())
    {
      int a = q.front().first.first;
      int b = q.front().first.second;
      int c = q.front().second.first;
      int d = q.front().second.second;
      q.pop();

      for (int i = 0; i < 6; ++i)
      {
        int z = a + move[i][0];
        int y = b + move[i][1];
        int x = c + move[i][2];

        if (z == ez && y == ey && x == ex)
        {
          answer = d + 1;
          flag = true;
          break;
        }
        if (map[z][y][x] == '.' && !visit[z][y][x])
        {
          visit[z][y][x] = true;
          q.push(make_pair(make_pair(z, y), make_pair(x, d + 1)));
        }
      }
      if (flag)
      {
        break;
      }
    }
    if (flag)
    {
      cout << "Escaped in ";
      cout << answer;
      cout << " minute(s)." << endl;
    }
    else
    {
      cout << "Trapped!" << endl;
    }
  }
  return 0;
}
