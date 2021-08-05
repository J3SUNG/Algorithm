#include <iostream>
#include <cstring>
#include <queue>
using namespace std;

int map[110][110][110];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};
int moveZ[2] = {-1, 1};
queue<vector<int>> q;

int main(int argc, char *argv[])
{
  int n, m, h;
  int a, b, c;
  int count;
  int x, y, z;
  int flag = 0;

  memset(map, -1, sizeof(map));

  cin >> m >> n >> h;

  for (int k = 1; k <= h; ++k)
  {
    for (int i = 1; i <= n; ++i)
    {
      for (int j = 1; j <= m; ++j)
      {
        cin >> map[k][i][j];
        if (map[k][i][j] == 1)
        {
          vector<int> element;
          element.push_back(k);
          element.push_back(i);
          element.push_back(j);
          element.push_back(0);
          q.push(element);
        }
      }
    }
  }

  while (!q.empty())
  {
    a = q.front()[0];
    b = q.front()[1];
    c = q.front()[2];
    count = q.front()[3];
    q.pop();

    for (int i = 0; i < 4; ++i)
    {
      x = b + moveX[i];
      y = c + moveY[i];

      if (map[a][x][y] == 0)
      {
        vector<int> element;
        element.push_back(a);
        element.push_back(x);
        element.push_back(y);
        element.push_back(count + 1);
        q.push(element);
        map[a][x][y] = 1;
      }
    }
    for (int i = 0; i < 2; ++i)
    {
      z = a + moveZ[i];

      if (map[z][b][c] == 0)
      {
        vector<int> element;
        element.push_back(z);
        element.push_back(b);
        element.push_back(c);
        element.push_back(count + 1);
        q.push(element);
        map[z][b][c] = 1;
      }
    }
  }
  for (int k = 1; k <= h; ++k)
  {
    for (int i = 1; i <= n; ++i)
    {
      for (int j = 1; j <= m; ++j)
      {
        if (map[k][i][j] == 0)
        {
          flag = 1;
        }
      }
    }
  }

  if (flag)
  {
    cout << "-1" << endl;
  }
  else
  {
    cout << count << endl;
  }

  return 0;
}
