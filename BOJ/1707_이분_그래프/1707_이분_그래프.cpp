#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

int n;
int success;
vector<int> vec[20010];
int color[20010];

void DFS(int a, int x)
{
  if (success != 0)
  {
    return;
  }

  if ((color[a] == 1 && x == 1) || (color[a] == 2 && x == 2))
  {
    success = -1;
    return;
  }
  else if (color[a] != 0)
  {
    return;
  }

  if (x == 2)
  {
    color[a] = 1;
    x = 1;
  }
  else if (x == 1)
  {
    color[a] = 2;
    x = 2;
  }

  for (int i = 0; i < vec[a].size(); ++i)
  {
    DFS(vec[a].at(i), x);
  }
}

int main(int argc, char *argv[])
{
  int v, e;
  int testcase;

  cin >> testcase;

  while (testcase--)
  {
    success = 0;

    cin >> v;
    cin >> e;

    for (int i = 1; i <= 20000; ++i)
    {
      vec[i].clear();
    }

    memset(color, 0, sizeof(color));

    for (int i = 0; i < e; ++i)
    {
      int a, b;

      cin >> a;
      cin >> b;

      vec[a].push_back(b);
      vec[b].push_back(a);
    }

    for (int i = 1; i <= v; ++i)
    {
      if (color[i] != 0)
      {
        continue;
      }

      DFS(i, 2);
    }

    if (success == -1)
    {
      cout << "NO" << endl;
    }
    else
    {
      cout << "YES" << endl;
    }
  }

  return 0;
}