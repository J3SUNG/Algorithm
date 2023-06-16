#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int map[510][510];
int DP[510][510];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

int search(int i, int j)
{
  int maxNum = 0;
  if (DP[i][j] != 1)
  {
    return DP[i][j];
  }
  for (int k = 0; k < 4; ++k)
  {
    int x = i - moveX[k];
    int y = j - moveY[k];
    if (map[i][j] < map[x][y])
    {
      maxNum = max(maxNum, search(x, y));
    }
  }
  DP[i][j] += maxNum;

  return DP[i][j];
}

int main(int argc, char *argv[])
{
  int maxNum = 0;
  int n;
  cin >> n;

  for (int i = 0; i <= n + 1; ++i)
  {
    for (int j = 0; j <= n + 1; ++j)
    {
      map[i][j] = 0;
      DP[i][j] = 1;
    }
  }

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= n; ++j)
    {
      cin >> map[i][j];
    }
  }

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= n; ++j)
    {
      search(i, j);
    }
  }

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= n; ++j)
    {
      maxNum = max(maxNum, DP[i][j]);
    }
  }
  cout << maxNum << endl;

  return 0;
}