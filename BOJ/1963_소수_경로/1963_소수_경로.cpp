#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;

int c;
int arr[10000];
int visit[10000];
queue<int> q;

void BFS(int a, int b)
{
  while (!q.empty())
  {
    !q.empty();
    int n1, n2, n3, n4;
    int x = q.front();
    q.pop();

    if (x == b)
    {
      while (!q.empty())
      {
        q.pop();
      }
      c = visit[b] - 1;
      return;
    }

    n1 = x / 1000;
    n2 = (x / 100) % 10;
    n3 = (x / 10) % 10;
    n4 = x % 10;

    for (int i = 0; i < 10; ++i)
    {
      int c1 = i * 1000 + n2 * 100 + n3 * 10 + n4;
      int c2 = n1 * 1000 + i * 100 + n3 * 10 + n4;
      int c3 = n1 * 1000 + n2 * 100 + i * 10 + n4;
      int c4 = n1 * 1000 + n2 * 100 + n3 * 10 + i;

      if (visit[c1] == 0 && arr[c1] == 0)
      {
        q.push(c1);
        visit[c1] = visit[x] + 1;
      }
      if (visit[c2] == 0 && arr[c2] == 0)
      {
        q.push(c2);
        visit[c2] = visit[x] + 1;
      }
      if (visit[c3] == 0 && arr[c3] == 0)
      {
        q.push(c3);
        visit[c3] = visit[x] + 1;
      }
      if (visit[c4] == 0 && arr[c4] == 0)
      {
        q.push(c4);
        visit[c4] = visit[x] + 1;
      }
    }
  }
}

int main(int argc, char *argv[])
{
  int n;
  int a, b;

  cin >> n;

  memset(arr, 0, sizeof(arr));

  for (int i = 2; i < 10000; ++i)
  {
    for (int j = i * 2; j < 10000; j += i)
    {
      if (j < 1000)
      {
        continue;
      }
      arr[j] = 1;
    }
  }
  for (int i = 0; i < 1000; ++i)
  {
    arr[i] = 1;
  }

  for (int i = 0; i < n; ++i)
  {
    memset(visit, 0, sizeof(visit));

    cin >> a;
    cin >> b;

    q.push(a);
    visit[a] = 1;
    c = 0;
    BFS(a, b);
    cout << c << endl;
  }

  return 0;
}