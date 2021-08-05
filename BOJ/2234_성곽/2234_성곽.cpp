#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

vector<vector<int>> v;
int visit[51][51];
int roomSize[2501];
int n, m;

void bfs(int a, int b, int c)
{
  queue<pair<int, int>> q;
  q.push(make_pair(a, b));
  visit[a][b] = c;

  while (!q.empty())
  {
    int y = q.front().first;
    int x = q.front().second;
    roomSize[c] += 1;
    q.pop();

    if (!(v[y][x] & 1) && visit[y][x - 1] == 0)
    {
      q.push(make_pair(y, x - 1));
      visit[y][x - 1] = c;
    }
    if (!(v[y][x] & 2) && visit[y - 1][x] == 0)
    {
      q.push(make_pair(y - 1, x));
      visit[y - 1][x] = c;
    }
    if (!(v[y][x] & 4) && visit[y][x + 1] == 0)
    {
      q.push(make_pair(y, x + 1));
      visit[y][x + 1] = c;
    }
    if (!(v[y][x] & 8) && visit[y + 1][x] == 0)
    {
      q.push(make_pair(y + 1, x));
      visit[y + 1][x] = c;
    }
  }
}

int main(int argc, char *argv[])
{
  int c = 0;
  int num;
  int maxSizeRoom = 0;
  int newSizeRoom = 0;

  cin >> n;
  cin >> m;

  memset(visit, 0, sizeof(visit));
  memset(roomSize, 0, sizeof(roomSize));

  for (int i = 0; i < m; ++i)
  {
    vector<int> temp;
    for (int j = 0; j < n; ++j)
    {
      cin >> num;
      temp.push_back(num);
    }
    v.push_back(temp);
    temp.clear();
  }

  for (int i = 0; i < m; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (visit[i][j] != 0)
      {
        continue;
      }
      ++c;
      bfs(i, j, c);
    }
  }

  for (int i = 0; i <= c; ++i)
  {
    maxSizeRoom = max(maxSizeRoom, roomSize[i]);
  }

  newSizeRoom = maxSizeRoom;

  for (int i = 0; i < m; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (i - 1 >= 0 && visit[i][j] != visit[i - 1][j])
      {
        newSizeRoom = max(newSizeRoom, roomSize[visit[i][j]] + roomSize[visit[i - 1][j]]);
      }
      if (j - 1 >= 0 && visit[i][j] != visit[i][j - 1])
      {
        newSizeRoom = max(newSizeRoom, roomSize[visit[i][j]] + roomSize[visit[i][j - 1]]);
      }
      if (i + 1 < m && visit[i][j] != visit[i + 1][j])
      {
        newSizeRoom = max(newSizeRoom, roomSize[visit[i][j]] + roomSize[visit[i + 1][j]]);
      }
      if (j + 1 >= n && visit[i][j] != visit[i][j + 1])
      {
        newSizeRoom = max(newSizeRoom, roomSize[visit[i][j]] + roomSize[visit[i][j + 1]]);
      }
    }
  }

  cout << c << endl;
  cout << maxSizeRoom << endl;
  cout << newSizeRoom << endl;

  return 0;
}
