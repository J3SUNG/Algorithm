#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <queue>
#include <vector>
using namespace std;

int n, m, v;
int visit[10010];
vector<vector<int>> vec;

void DFS(int z)
{
  visit[z] = 1;
  cout << z << " ";
  for (int i = 0; i < vec[z].size(); ++i)
  {
    int x = vec[z][i];
    if (visit[x] == 0)
    {
      DFS(x);
    }
  }
}

void BFS(int z)
{
  int l = z;
  queue<int> q;
  visit[l] = 1;
  q.push(l);

  while (!q.empty())
  {
    l = q.front();
    q.pop();
    cout << l << " ";

    for (int i = 0; i < vec[l].size(); ++i)
    {
      int x = vec[l][i];
      if (visit[x] == 0)
      {
        visit[x] = 1;
        q.push(x);
      }
    }
  }
}

int main(int argc, char *argv[])
{
  cin >> n;
  cin >> m;
  cin >> v;

  for (int i = 0; i <= n; ++i)
  {
    vector<int> e;
    vec.push_back(e);
  }

  for (int i = 0; i < m; ++i)
  {
    int x, y;

    cin >> x >> y;

    vec[x].push_back(y);
    vec[y].push_back(x);
  }

  for (int i = 0; i <= n; ++i)
  {
    sort(vec[i].begin(), vec[i].end());
  }

  memset(visit, 0, sizeof(visit));
  DFS(v);
  cout << endl;

  memset(visit, 0, sizeof(visit));
  BFS(v);
  cout << endl;

  return 0;
}