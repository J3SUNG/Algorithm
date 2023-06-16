#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int m, n, k;
int c;
int arrCount = 0;
int map[110][110];
int arr[10000];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

void DFS(int a, int b)
{
  if (map[a][b] == 0)
  {
    map[a][b] = 1;
    ++c;
    for (int l = 0; l < 4; ++l)
    {
      int x = moveX[l] + a;
      int y = moveY[l] + b;
      if (x >= 0 && y >= 0 && x < m && y < n)
      {
        DFS(x, y);
      }
    }
  }
}

int main(int argc, char *argv[])
{
  int x1, y1, x2, y2;

  memset(map, 0, sizeof(map));
  memset(arr, 0, sizeof(arr));

  cin >> m;
  cin >> n;
  cin >> k;

  while (k--)
  {
    cin >> x1 >> y1;
    cin >> x2 >> y2;

    for (int i = x1; i < x2; ++i)
    {
      for (int j = y1; j < y2; ++j)
      {
        map[j][i] = 1;
      }
    }
  }
  for (int i = 0; i < m; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (map[i][j] == 0)
      {
        c = 0;
        DFS(i, j);
        arr[arrCount++] = c;
      }
    }
  }
  sort(arr, arr + arrCount);

  cout << arrCount << endl;

  for (int i = 0; i < arrCount; ++i)
  {
    cout << arr[i] << " ";
  }

  return 0;
}