#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <queue>
using namespace std;

int N, K;
int visit[200010];

void BFS()
{
  int l = N;
  queue<int> q;
  visit[l] = 0;
  q.push(l);

  while (!q.empty())
  {
    l = q.front();
    q.pop();

    if (l == K)
    {
      cout << visit[K] << endl;
      return;
    }

    if (l + 1 <= K && visit[l + 1] == -1)
    {
      q.push(l + 1);
      visit[l + 1] = visit[l] + 1;
    }
    if (l - 1 >= 0 && visit[l - 1] == -1)
    {
      q.push(l - 1);
      visit[l - 1] = visit[l] + 1;
    }
    if (l * 2 <= K * 2 && visit[l * 2] == -1)
    {
      q.push(l * 2);
      visit[l * 2] = visit[l] + 1;
    }
  }
}

int main(int argc, char *argv[])
{
  memset(visit, -1, sizeof(visit));

  cin >> N;
  cin >> K;

  BFS();

  return 0;
}