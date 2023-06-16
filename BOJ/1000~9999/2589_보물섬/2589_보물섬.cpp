#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <queue>
using namespace std;

int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

int main(int argc, char *argv[])
{
  int n, m;
  int x, y;
  int a, b, c;
  int count = 0;
  int dist = 0;
  int map[60][60];
  int visit[60][60];
  string s;
  queue<pair<int, int>> land;
  queue<pair<pair<int, int>, int>> q;

  cin >> n >> m;

  memset(map, 0, sizeof(map));

  for (int i = 1; i <= n; ++i)
  {
    cin >> s;
    for (int j = 1; j <= m; ++j)
    {
      if (s[j - 1] == 'L')
      {
        map[i][j] = 1;
        land.push(make_pair(i, j));
      }
    }
  }

  while (!land.empty())
  {
    q.push(make_pair(make_pair(land.front().first, land.front().second), 0));
    land.pop();
    memset(visit, 0, sizeof(visit));

    while (!q.empty())
    {
      a = q.front().first.first;
      b = q.front().first.second;
      c = q.front().second;
      visit[a][b] = 1;
      q.pop();

      for (int i = 0; i < 4; ++i)
      {
        x = moveX[i] + a;
        y = moveY[i] + b;

        if (!visit[x][y] && map[x][y])
        {
          q.push(make_pair(make_pair(x, y), c + 1));
          visit[x][y] = 1;
        }
      }
    }

    dist = max(dist, c);
  }

  cout << dist << endl;

  return 0;
}