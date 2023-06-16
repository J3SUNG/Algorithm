#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <queue>
using namespace std;

int F, S, G, U, D;
int visit[1000010];

void BFS()
{
  int x;
  int l = S;
  queue<int> q;
  visit[l] = 0;
  q.push(l);

  while (!q.empty())
  {
    l = q.front();
    q.pop();

    if (l == G)
    {
      cout << visit[G] << endl;
      return;
    }

    if (l + U <= F && visit[l + U] == -1)
    {
      q.push(l + U);
      visit[l + U] = visit[l] + 1;
    }
    if (l - D > 0 && visit[l - D] == -1)
    {
      q.push(l - D);
      visit[l - D] = visit[l] + 1;
    }
  }

  cout << "use the stairs" << endl;
}

int main(int argc, char *argv[])
{
  cin >> F;
  cin >> S;
  cin >> G;
  cin >> U;
  cin >> D;

  memset(visit, -1, sizeof(visit));

  BFS();

  return 0;
}