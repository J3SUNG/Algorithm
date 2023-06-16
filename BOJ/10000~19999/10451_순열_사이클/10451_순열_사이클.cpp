#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

int ts;
int n;
int num;
int c = 1;
int cycle;
int visit[1010];
vector<vector<int>> v;

int DFS(int cur)
{
  int r = 1;
  for (int i = 0; i < v[cur].size(); ++i)
  {
    if (visit[cur] == 0)
    {
      visit[cur] = c;
      r = min(r, DFS(v[cur][i]));
    }
    else if (visit[cur] == c)
    {
      return 1;
    }
    else
    {
      return 0;
    }
  }
  return r;
}

int main(int argc, char *argv[])
{
  cin >> ts;

  while (ts--)
  {
    cin >> n;

    c = 1;
    v.clear();
    v.resize(n + 1);
    memset(visit, 0, sizeof(visit));

    for (int i = 1; i <= n; ++i)
    {
      cin >> num;
      v[i].push_back(num);
    }

    for (int i = 1; i < n + 1; ++i)
    {
      cycle = 0;
      if (visit[i] == 0)
      {
        cycle = DFS(i);
      }
      c += cycle;
    }

    cout << c - 1 << endl;
  }

  return 0;
}