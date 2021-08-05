#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
#include <stack>
#include <string>
using namespace std;

int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

int main(int argc, char *argv[])
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int R, C, T;
  int num;
  int map[60][60];
  int cal[60][60];
  vector<pair<int, int>> v;
  queue<pair<int, int>> q;

  memset(map, -1, sizeof(map));

  cin >> R >> C >> T;

  for (int i = 1; i <= R; ++i)
  {
    for (int j = 1; j <= C; ++j)
    {
      cin >> num;
      map[i][j] = num;
      if (num == -1)
      {
        v.push_back({i, j});
      }
      else if (num > 0)
      {
        q.push({i, j});
      }
    }
  }

  int c = 0;
  while (c < T)
  {
    memset(cal, 0, sizeof(cal));

    while (!q.empty())
    {
      int queueY = q.front().first;
      int queueX = q.front().second;
      q.pop();

      int count = 0;

      for (int i = 0; i < 4; ++i)
      {
        int nextX = queueX + moveX[i];
        int nextY = queueY + moveY[i];

        if (map[nextY][nextX] != -1)
        {
          ++count;
          cal[nextY][nextX] += map[queueY][queueX] / 5;
        }
      }
      int sub = map[queueY][queueX] / 5;
      cal[queueY][queueX] -= sub * count;
    }

    for (int i = 1; i <= R; ++i)
    {
      for (int j = 1; j <= C; ++j)
      {
        if (cal[i][j] != 0)
        {
          map[i][j] += cal[i][j];
        }
      }
    }

    int airY = v[0].first;
    int airX = v[0].second;

    ++airX;
    int temp = 0;
    int prev = 0;
    while (1)
    {
      if (map[airY][airX] == -1)
      {
        --airX;
        --airY;
        break;
      }
      temp = map[airY][airX];
      map[airY][airX] = prev;
      prev = temp;

      ++airX;
    }
    while (1)
    {
      if (map[airY][airX] == -1)
      {
        ++airY;
        --airX;
        break;
      }
      temp = map[airY][airX];
      map[airY][airX] = prev;
      prev = temp;

      --airY;
    }
    while (1)
    {
      if (map[airY][airX] == -1)
      {
        ++airX;
        ++airY;
        break;
      }
      temp = map[airY][airX];
      map[airY][airX] = prev;
      prev = temp;

      --airX;
    }
    while (1)
    {
      if (map[airY][airX] == -1)
      {
        --airY;
        break;
      }
      temp = map[airY][airX];
      map[airY][airX] = prev;
      prev = temp;

      ++airY;
    }

    airY = v[1].first;
    airX = v[1].second;
    prev = 0;
    temp = 0;

    ++airX;
    while (1)
    {
      if (map[airY][airX] == -1)
      {
        --airX;
        ++airY;
        break;
      }
      temp = map[airY][airX];
      map[airY][airX] = prev;
      prev = temp;

      ++airX;
    }
    while (1)
    {
      if (map[airY][airX] == -1)
      {
        --airY;
        --airX;
        break;
      }
      temp = map[airY][airX];
      map[airY][airX] = prev;
      prev = temp;

      ++airY;
    }
    while (1)
    {
      if (map[airY][airX] == -1)
      {
        ++airX;
        --airY;
        break;
      }
      temp = map[airY][airX];
      map[airY][airX] = prev;
      prev = temp;

      --airX;
    }
    while (1)
    {
      if (map[airY][airX] == -1)
      {
        ++airY;
        break;
      }
      temp = map[airY][airX];
      map[airY][airX] = prev;
      prev = temp;

      --airY;
    }

    for (int i = 1; i <= R; ++i)
    {
      for (int j = 1; j <= C; ++j)
      {
        if (map[i][j] > 0)
        {
          q.push({i, j});
        }
      }
    }

    ++c;
  }

  int result = 0;
  for (int i = 1; i <= R; ++i)
  {
    for (int j = 1; j <= C; ++j)
    {
      if (map[i][j] != -1)
      {
        result += map[i][j];
      }
    }
  }

  cout << result << endl;

  return 0;
}