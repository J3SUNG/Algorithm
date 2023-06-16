#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

int visit[210];
int room[210];
vector<vector<int>> v;

int solve(int x)
{
  if (visit[x])
  {
    return 0;
  }

  visit[x] = 1;

  for (int go : v[x])
  {
    if (!room[go] || solve(room[go]))
    {
      room[go] = x;
      return 1;
    }
  }
  return 0;
}

int main(int argc, char *argv[])
{
  int n, m;

  cin >> n;
  cin >> m;

  memset(room, 0, sizeof(room));

  for (int i = 0; i <= n; ++i)
  {
    vector<int> element;
    v.push_back(element);
  }

  for (int i = 1; i <= n; ++i)
  {
    int want;

    cin >> want;

    for (int j = 0; j < want; ++j)
    {
      int num;

      cin >> num;

      v[i].push_back(num);
    }
  }

  int count = 0;
  for (int i = 1; i <= n; ++i)
  {
    fill(begin(visit), end(visit), 0);

    if (solve(i))
    {
      ++count;
    }
  }

  cout << count << endl;

  return 0;
}