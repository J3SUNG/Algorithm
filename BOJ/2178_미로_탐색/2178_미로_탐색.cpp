#include <iostream>
#include <string>
#include <algorithm>
#include <cstring>
#include <queue>
using namespace std;

int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

int main(int argc, char *argv[])
{
  int n, m;
  int map[110][110];
  int visit[110][110];
  int a, b;
  int x, y;
  int c;
  string s;
  queue<pair<pair<int, int>, int>> q;

  cin >> n >> m;

  memset(map, 0, sizeof(map));
  memset(visit, 0, sizeof(visit));

  for (int i = 1; i <= n; ++i)
  {
    cin >> s;
    for (int j = 1; j <= m; ++j)
    {
      map[i][j] = s[j - 1] - '0';
    }
  }

  q.push(make_pair(make_pair(1, 1), 1));
  visit[1][1] = 1;

  while (!q.empty())
  {
    a = q.front().first.first;
    b = q.front().first.second;
    c = q.front().second;

    if (n == a && m == b)
    {
      break;
    }

    q.pop();
    for (int i = 0; i < 4; ++i)
    {
      x = moveX[i] + a;
      y = moveY[i] + b;

      if (visit[x][y] == 0 && map[x][y])
      {
        visit[x][y] = 1;
        q.push(make_pair(make_pair(x, y), c + 1));
      }
    }
  }

  cout << c << endl;

  return 0;
}