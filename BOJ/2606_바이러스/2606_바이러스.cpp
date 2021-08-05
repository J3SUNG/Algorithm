#include <iostream>
#include <string>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

vector<int> v[110];
int visit[110];
int c = 0;

void DFS(int x)
{
  visit[x] = 1;
  ++c;

  for (int i = 0; i < v[x].size(); ++i)
  {
    if (!visit[v[x][i]])
    {
      DFS(v[x][i]);
    }
  }
}

int main(int argc, char *argv[])
{
  int n, m;
  int a, b;

  cin >> n >> m;

  memset(visit, 0, sizeof(visit));

  for (int i = 0; i < m; ++i)
  {
    cin >> a >> b;

    v[a].push_back(b);
    v[b].push_back(a);
  }

  for (int i = 0; i < v[1].size(); ++i)
  {
    if (!visit[v[1][i]])
    {
      visit[1] = 1;
      DFS(v[1][i]);
    }
  }

  cout << c << endl;

  return 0;
}