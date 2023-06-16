#include <iostream>
#include <cstring>
#include <string>
#include <queue>
#include <algorithm>
#define MAX 987654321
using namespace std;

int main(int argc, char *argv[])
{
  int n, m;
  int move[4][2] = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
  int visit[102][102];
  char map[102][102];
  vector<pair<int, int>> v;                      // 시작좌표, 도착좌표
  queue<pair<pair<int, int>, pair<int, int>>> q; // Y좌표, X좌표, 최근방향, 회전횟수

  cin >> m >> n;

  memset(map, '*', sizeof(map));

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= m; ++j)
    {
      cin >> map[i][j];

      if (map[i][j] == 'C')
      {
        map[i][j] = '.';
        v.push_back(make_pair(i, j));
      }
      visit[i][j] = MAX;
    }
  }

  for (int i = 0; i < 4; ++i)
  {
    q.push(make_pair(make_pair(v[0].first, v[0].second), make_pair(i, 0)));
  }
  visit[v[0].first][v[0].second] = 0;

  while (!q.empty())
  {
    int a = q.front().first.first;
    int b = q.front().first.second;
    int c = q.front().second.first;
    int d = q.front().second.second;
    q.pop();

    for (int i = 0; i < 4; ++i)
    {
      int y = a + move[i][0];
      int x = b + move[i][1];
      int z = d;

      if (i != c)
      {
        ++z;
      }

      if (map[y][x] == '.' && visit[y][x] >= z)
      {
        visit[y][x] = z;
        q.push(make_pair(make_pair(y, x), make_pair(i, z)));
      }
    }
  }

  cout << visit[v[1].first][v[1].second] << endl;

  return 0;
}