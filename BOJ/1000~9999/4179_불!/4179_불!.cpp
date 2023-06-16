#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

bool flag = false;
int n, m;
int turn = 1;
int result = 0;
bool visit[1010][1010];
char map[1010][1010];
int movement[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
queue<pair<pair<int, int>, int>> jh;
queue<pair<int, int>> fire;

int main(int argc, char *argv[])
{
  cin >> n >> m;

  memset(visit, false, sizeof(visit));
  memset(map, ' ', sizeof(map));
  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= m; ++j)
    {
      cin >> map[i][j];
      if (map[i][j] == 'J')
      {
        map[i][j] = '.';
        jh.push(make_pair(make_pair(i, j), 1));
        visit[i][j] = true;
      }
      if (map[i][j] == 'F')
      {
        map[i][j] = '#';
        fire.push(make_pair(i, j));
      }
    }
  }

  while (!jh.empty())
  {
    int jx = jh.front().first.second;
    int jy = jh.front().first.first;
    int jc = jh.front().second;
    jh.pop();

    if (turn == jc)
    {
      int cycle = fire.size();
      for (int i = 0; i < cycle; ++i)
      {
        int fx = fire.front().second;
        int fy = fire.front().first;
        fire.pop();
        for (int j = 0; j < 4; ++j)
        {
          int nextFx = fx + movement[j][1];
          int nextFy = fy + movement[j][0];
          if (map[nextFy][nextFx] == '.')
          {
            fire.push(make_pair(nextFy, nextFx));
            map[nextFy][nextFx] = '#';
          }
        }
      }

      ++turn;
    }

    for (int i = 0; i < 4; ++i)
    {
      int nextJx = jx + movement[i][1];
      int nextJy = jy + movement[i][0];

      if (map[nextJy][nextJx] == ' ')
      {
        flag = true;
        result = jc;
        break;
      }

      if (!visit[nextJy][nextJx] && map[nextJy][nextJx] == '.')
      {
        visit[nextJy][nextJx] = true;
        jh.push(make_pair(make_pair(nextJy, nextJx), jc + 1));
      }
    }

    if (flag)
    {
      break;
    }
  }

  if (!flag)
  {
    cout << "IMPOSSIBLE" << endl;
  }
  else
  {
    cout << result << endl;
  }

  return 0;
}