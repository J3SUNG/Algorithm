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
  int turn;
  int waterA, waterB, waterX, waterY;
  int waterCycle;
  int map[60][60];
  int visit[60][60];
  string s;
  queue<pair<pair<int, int>, int>> q;
  queue<pair<int, int>> water;
  cin >> n >> m;

  memset(map, 0, sizeof(map));

  for (int i = 1; i <= n; ++i)
  {
    cin >> s;
    for (int j = 1; j <= m; ++j)
    {
      if (s[j - 1] == 'X')
      { // 돌 = 0
        map[i][j] = 0;
      }
      else if (s[j - 1] == '*')
      { // 물 = 1;
        map[i][j] = 1;
        water.push(make_pair(i, j));
      }
      else if (s[j - 1] == '.')
      { // 땅굴 = 2;
        map[i][j] = 2;
      }
      else if (s[j - 1] == 'D')
      { // 비버 = 3;
        map[i][j] = 3;
      }
      else if (s[j - 1] == 'S')
      { // 두더지;
        map[i][j] = 2;
        q.push(make_pair(make_pair(i, j), 0));
      }
    }
  }

  memset(visit, 0, sizeof(visit));
  turn = 1;

  while (!q.empty())
  {
    a = q.front().first.first;
    b = q.front().first.second;
    c = q.front().second;
    visit[a][b] = 1;
    q.pop();

    if (turn != c)
    {
      turn = c;
      waterCycle = water.size();
      while (waterCycle--)
      {
        waterA = water.front().first;
        waterB = water.front().second;
        water.pop();
        for (int i = 0; i < 4; ++i)
        {
          waterX = waterA + moveX[i];
          waterY = waterB + moveY[i];
          if (map[waterX][waterY] == 2)
          {
            water.push(make_pair(waterX, waterY));
            map[waterX][waterY] = 1;
          }
        }
      }
    }

    for (int i = 0; i < 4; ++i)
    {
      x = moveX[i] + a;
      y = moveY[i] + b;
      if (map[x][y] == 3)
      {
        cout << c + 1 << endl;
        return 0;
      }
      if (!visit[x][y] && map[x][y] == 2)
      {
        q.push(make_pair(make_pair(x, y), c + 1));
        visit[x][y] = 1;
      }
    }
  }

  cout << "KAKTUS" << endl;

  return 0;
}