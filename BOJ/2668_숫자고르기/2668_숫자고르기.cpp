#include <iostream>
#include <cstring>
using namespace std;

int n;
int countNum;
int flag;
int map[110][110];
int visit[110];
int arr[110];

void DFS(int a, int b, int x)
{
  if (flag == 1)
  {
    return;
  }

  if (b == x && visit[x] == 1)
  {
    arr[x] = x;
    flag = 1;
    ++countNum;
    return;
  }

  visit[b] = 1;

  for (int j = 1; j <= n && flag == 0; ++j)
  {
    if (map[b][j] == 1 && (j == x || visit[j] == 0))
    {
      DFS(b, j, x);
    }
  }
}

int main(int argc, char *argv[])
{
  countNum = 0;

  cin >> n;

  memset(map, 0, sizeof(map));
  memset(arr, 0, sizeof(arr));

  for (int i = 1; i <= n; ++i)
  {
    int a;
    cin >> a;
    map[i][a] = 1;
  }

  for (int i = 1; i <= n; ++i)
  {
    flag = 0;
    memset(visit, 0, sizeof(visit));
    DFS(0, i, i);
  }

  cout << countNum << endl;

  for (int i = 0; i <= n; ++i)
  {
    if (arr[i] != 0)
    {
      cout << arr[i] << endl;
    }
  }

  return 0;
}