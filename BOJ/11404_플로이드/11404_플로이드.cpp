#include <iostream>
#include <algorithm>
#define INF 987654321
using namespace std;

int d[101][101];
int n, m;

void Init()
{
  for (int i = 1; i <= n; i++)
  {
    for (int j = 1; j <= n; j++)
    {
      d[i][j] = INF;
    }
  }
}

void Floyd()
{
  for (int m = 1; m <= n; m++)
  {
    for (int s = 1; s <= n; s++)
    {
      for (int e = 1; e <= n; e++)
      {
        if (d[s][m] != INF && d[m][e] != INF)
        {
          d[s][e] = min(d[s][e], d[s][m] + d[m][e]);
        }
      }
    }
  }
}

int main(int argc, char *argv[])
{
  cin >> n;
  cin >> m;
  Init();
  for (int i = 0; i < m; i++)
  {
    int x, y, c;
    cin >> x;
    cin >> y;
    cin >> c;
    if (d[x][y] > c)
    {
      d[x][y] = c;
    }
  }
  Floyd();

  for (int i = 1; i <= n; i++)
  {
    for (int j = 1; j <= n; j++)
    {
      if (i == j || d[i][j] == INF)
      {
        cout << "0 ";
      }
      else
      {
        cout << d[i][j] << " ";
      }
    }
    cout << endl;
  }
  return 0;
}