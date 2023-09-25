#include <iostream>
#include <cstring>
using namespace std;

int map[20][20];
int DP[20][20];
int checkX = -1;
int checkY;
int n, m;
int num;

int move(int x, int y)
{
  if (x == m - 1 && y == n - 1)
  {
    return 1;
  }
  
  if (DP[y][x] == -1)
  { // 길이 없을 때
    return 0;
  }
  else if (DP[y][x] > 0)
  { // 길이 있을 때
    return DP[y][x];
  }

  DP[y][x] += move(x + 1, y);
  DP[y][x] += move(x, y + 1);

  return DP[y][x];
}

int main(int argc, char *argv[])
{
  memset(map, 0, sizeof(map));
  memset(DP, -1, sizeof(DP));

  cin >> n >> m;
  cin >> num;

  checkX = (num - 1) % m;
  checkY = (num - 1) / m;

  if (checkX != -1)
  {
    for (int i = 0; i <= checkX; ++i)
    {
      for (int j = 0; j <= checkY; ++j)
        DP[j][i] = 0;
    }

    for (int i = checkX; i < m; ++i)
    {
      for (int j = checkY; j < n; ++j)
        DP[j][i] = 0;
    }
  }
  else
  {
    for (int i = 0; i < m; ++i)
    {
      for (int j = 0; j < n; ++j)
        DP[j][i] = 0;
    }
  }

  move(0, 0);

  cout << DP[0][0] << endl;

  return 0;
}