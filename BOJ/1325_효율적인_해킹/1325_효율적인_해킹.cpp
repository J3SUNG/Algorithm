#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

vector<int> v[10010];
int visit[10010];
int arr[10010];
int flag;
int c;

void DFS(int a, int x)
{
  visit[a] = 1;

  for (int i = 0; i < v[a].size(); ++i)
  {
    int b = v[a].at(i);
    if (visit[b] == 0)
    {
      DFS(b, x);
      ++c;
    }
  }
}

int main(int argc, char *argv[])
{
  int n, m;
  int maxNum = -987654321;

  scanf("%d", &n);
  scanf("%d", &m);

  memset(visit, 0, sizeof(visit));

  for (int i = 1; i <= m; ++i)
  {
    int a;
    int b;

    scanf("%d", &b);
    scanf("%d", &a);

    v[a].push_back(b);
  }

  for (int i = 1; i <= n; ++i)
  {
    flag = false;
    c = 0;
    memset(visit, 0, sizeof(visit));
    DFS(i, i);
    arr[i] = c;
    maxNum = max(maxNum, c);
  }

  for (int i = 1; i <= n; ++i)
  {
    if (arr[i] == maxNum)
    {
      printf("%d ", i);
    }
  }

  return 0;
}