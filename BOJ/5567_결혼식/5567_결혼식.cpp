#include <iostream>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
  int n, m;
  int x, y;
  int count = 0;
  int visit[501] = {
      0,
  };
  vector<vector<pair<int, int>>> v;
  queue<pair<int, int>> q;

  cin >> n >> m;

  v.resize(n + 1);
  for (int i = 0; i < m; ++i)
  {
    cin >> x >> y;

    v[x].push_back(make_pair(y, 0));
    v[y].push_back(make_pair(x, 0));
  }

  q.push(make_pair(1, 0));
  visit[1] = 1;

  while (!q.empty())
  {
    int s = q.front().first;
    int n = q.front().second;

    q.pop();

    if (n == 2)
    {
      continue;
    }

    for (int i = 0; i < v[s].size(); ++i)
    {
      int e = v[s][i].first;
      if (visit[e] == 0)
      {
        visit[e] = 1;
        ++count;
        q.push(make_pair(e, n + 1));
      }
    }
  }

  cout << count << endl;

  return 0;
}