#include <iostream>
#include <vector>
using namespace std;

vector<pair<int, int>> v(1010);
int work[1010];
bool finish[1010];

bool DFS(int x)
{
  int size = v[x].second - v[x].first + 1;
  for (int i = 0; i < size; ++i)
  {
    int t = v[x].first + i;

    if (finish[t])
    {
      continue;
    }
    finish[t] = true;

    if (work[t] == 0 || DFS(work[t]))
    {
      work[t] = x;
      return true;
    }
  }
  return false;
}

int main(int argc, char *argv[])
{
  int t;
  int n, m;
  int start, end;
  int count;

  cin >> t;

  while (t--)
  {
    count = 0;

    cin >> n >> m;

    v.clear();
    v.push_back({0, 0});

    for (int i = 1; i <= m; ++i)
    {
      cin >> start;
      cin >> end;
      v.push_back({start, end});
    }

    fill(work, work + 1010, 0);
    for (int i = 1; i <= m; ++i)
    {
      fill(finish, finish + 1010, false);
      if (DFS(i))
      {
        ++count;
      }
    }

    cout << count << endl;
  }
  return 0;
}