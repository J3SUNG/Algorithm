#include <iostream>
#include <cstring>
#include <string>
#include <queue>
#include <algorithm>
#define MAX 987654321
using namespace std;

int n, m;
int countNum = MAX;
int map[1010][1010];
int visit[1010][1010][2];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};
queue<vector<int>> q;

void BFS()
{
  int a, b, c, d;
  int x, y;
  vector<int> v;
  v.push_back(1);
  v.push_back(1);
  v.push_back(1);
  v.push_back(0);
  q.push(v);
  while (!q.empty())
  {
    a = q.front()[0];
    b = q.front()[1];
    c = q.front()[2];
    d = q.front()[3];
    q.pop();

    for (int i = 0; i < 4; ++i)
    {
      x = moveX[i] + a;
      y = moveY[i] + b;

      if (x == n && y == m)
      {
        while (!q.empty())
        {
          q.pop();
        }
        ++c;
        countNum = min(countNum, c);
      }
      if (map[x][y] == 1 && d == 0)
      {
        vector<int> element;
        element.push_back(x);
        element.push_back(y);
        element.push_back(c + 1);
        element.push_back(1);
        q.push(element);
      }
      if (abs(map[x][y]) != 1 && visit[x][y][d] == 0)
      {

        visit[x][y][d] = 1;
        vector<int> element;
        element.push_back(x);
        element.push_back(y);
        element.push_back(c + 1);
        element.push_back(d);
        q.push(element);
      }
    }
  }
  return;
}

int main(int argc, char *argv[])
{
  int k = 2;
  string s;

  cin >> n >> m;

  memset(map, -1, sizeof(map));

  if (n == 1 && m == 1)
  {
    cout << "1" << endl;
    return 0;
  }

  for (int i = 1; i <= n; ++i)
  {
    cin >> s;
    for (int j = 1; j <= m; ++j)
    {
      map[i][j] = s[j - 1] - '0';
    }
  }

  BFS();

  if (countNum == MAX)
  {
    cout << "-1" << endl;
  }
  else
  {
    cout << countNum << endl;
  }

  return 0;
}
