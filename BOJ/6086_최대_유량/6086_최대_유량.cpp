#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
#define MAX 52
#define INF 987654321

using namespace std;

int N;
int result = 0;
int p[MAX];
int c[MAX][MAX];
int f[MAX][MAX];
vector<int> v[MAX];

char ctoi(char x)
{
  if (x <= 'Z')
  {
    return x - 'A';
  }
  return x - 'a' + 26;
}

int main(int argc, char *argv[])
{
  memset(c, 0, sizeof(c));
  memset(f, 0, sizeof(f));

  scanf("%d", &N);
  getchar();

  for (int i = 0; i < N; ++i)
  {
    char a, b;
    int num;

    scanf("%c %c %d", &a, &b, &num);
    getchar();

    a = ctoi(a);
    b = ctoi(b);

    c[a][b] += num;
    c[b][a] += num;
    v[a].push_back(b);
    v[b].push_back(a);
  }

  int start = ctoi('A');
  int end = ctoi('Z');

  while (1)
  {
    memset(p, -1, sizeof(p));
    queue<int> q;
    q.push(start);

    while (!q.empty())
    {
      int cur = q.front();
      q.pop();

      if (cur == end)
      {
        break;
      }

      for (int i = 0; i < v[cur].size(); ++i)
      {
        int next = v[cur][i];

        if (p[next] == -1 && c[cur][next] - f[cur][next] > 0)
        {
          q.push(next);
          p[next] = cur;
        }
      }
    }

    if (p[end] == -1)
    {
      break;
    }

    int minFlow = INF;
    for (int i = end; i != start; i = p[i])
    {
      minFlow = min(minFlow, c[p[i]][i] - f[p[i]][i]);
    }

    for (int i = end; i != start; i = p[i])
    {
      f[p[i]][i] += minFlow;
      f[i][p[i]] -= minFlow;
    }

    result += minFlow;
  }

  printf("%d\n", result);

  return 0;
}