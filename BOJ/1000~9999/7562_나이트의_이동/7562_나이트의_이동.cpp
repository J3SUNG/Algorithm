#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <queue>
using namespace std;

int moveX[8] = {2, 2, -2, -2, 1, 1, -1, -1};
int moveY[8] = {1, -1, 1, -1, 2, -2, 2, -2};

int main(int argc, char *argv[])
{
  int ts;
  int n;
  int a, b, c;
  int x, y;
  int findA, findB;
  int flag = 0;
  int map[310][310];
  queue<pair<pair<int, int>, int>> q;

  cin >> ts;

  while (ts--)
  {
    flag = 0;

    cin >> n;
    cin >> a >> b;
    cin >> findA >> findB;

    memset(map, 0, sizeof(map));
    while (!q.empty())
    {
      q.pop();
    }

    q.push(make_pair(make_pair(a, b), 0));

    while (1)
    {
      a = q.front().first.first;
      b = q.front().first.second;
      c = q.front().second;
      map[a][b] = 1;
      q.pop();

      if (a == findA && b == findB)
      {
        break;
      }

      for (int i = 0; i < 8; ++i)
      {
        x = moveX[i] + a;
        y = moveY[i] + b;
        if (x == findA && y == findB)
        {
          flag = 1;
          break;
        }
        if (x >= 0 && y >= 0 && x < n && y < n && !map[x][y])
        {
          q.push(make_pair(make_pair(x, y), c + 1));
          map[x][y] = 1;
        }
      }
      if (flag)
      {
        ++c;
        break;
      }
    }
    cout << c << endl;
  }

  return 0;
}