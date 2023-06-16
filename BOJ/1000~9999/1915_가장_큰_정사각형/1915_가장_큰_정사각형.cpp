#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int n, m;
int map[1010][1010];
int moveX[3] = {-1, 0, -1};
int moveY[3] = {0, -1, -1};

int main(int argc, char *argv[])
{
  string s;
  cin >> n;
  cin >> m;

  memset(map, 0, sizeof(map));
  for (int i = 1; i <= n; ++i)
  {
    cin >> s;
    for (int j = 1; j <= m; ++j)
    {
      map[i][j] = s[j - 1] - '0';
    }
  }

  int minNum;
  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= m; ++j)
    {
      minNum = 1010;

      if (map[i][j] == 0)
      {
        continue;
      }

      for (int k = 0; k < 3; ++k)
      {
        int x = i + moveX[k];
        int y = j + moveY[k];

        minNum = min(minNum, map[x][y]);
        if (map[x][y] == 0)
        {
          break;
        }

        if (k == 2)
        {
          map[i][j] = minNum + 1;
          break;
        }
      }
    }
  }

  int maxNum = 0;
  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= m; ++j)
    {
      maxNum = max(maxNum, map[i][j]);
    }
  }
  cout << maxNum * maxNum << endl;

  return 0;
}