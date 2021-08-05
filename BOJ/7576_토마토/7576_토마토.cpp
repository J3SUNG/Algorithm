#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

int map[1010][1010];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};
queue<pair<pair<int, int>, int>> q;

int main(int argc, char *argv[])
{
  int n, m;
  int a, b, c;
  int x, y;
  int flag = 0;

  memset(map, -1, sizeof(map));

  cin >> m >> n;

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= m; ++j)
    {
      cin >> map[i][j];
      if (map[i][j] == 1)
      {
        q.push(make_pair(make_pair(i, j), 0));
      }
    }
  }

  while (!q.empty())
  {
    a = q.front().first.first;
    b = q.front().first.second;
    c = q.front().second;
    q.pop();

    for (int i = 0; i < 4; ++i)
    {
      x = a + moveX[i];
      y = b + moveY[i];

      if (map[x][y] == 0)
      {
        q.push(make_pair(make_pair(x, y), c + 1));
        map[x][y] = 1;
      }
    }
  }

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= m; ++j)
    {
      if (map[i][j] == 0)
      {
        flag = 1;
      }
    }
  }

  if (flag)
  {
    cout << "-1" << endl;
  }
  else
  {
    cout << c << endl;
  }

  return 0;
}
