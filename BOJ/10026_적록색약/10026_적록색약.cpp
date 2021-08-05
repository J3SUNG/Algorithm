#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

void DFS(char map[][110], int a, int b, int c)
{
  if (map[a][b] != 0)
  {
    map[a][b] = 0;

    for (int i = 0; i < 4; ++i)
    {
      int x = a + moveX[i];
      int y = b + moveY[i];
      if (map[x][y] == c && x >= 0 && y >= 0)
      {
        DFS(map, x, y, c);
      }
    }
  }
}

int main(int argc, char *argv[])
{
  int n;
  int count = 0;
  int cbCount = 0;
  char map[110][110];
  char cbMap[110][110];
  string s;

  memset(map, 0, sizeof(map));
  memset(cbMap, 0, sizeof(cbMap));

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> s;
    for (int j = 0; j < n; ++j)
    {
      map[i][j] = s[j];
      if (s[j] == 'G')
      {
        cbMap[i][j] = 'R';
      }
      else
      {
        cbMap[i][j] = s[j];
      }
    }
  }

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (map[i][j] != 0)
      {
        int c = map[i][j];
        DFS(map, i, j, c);
        ++count;
      }
      if (cbMap[i][j] != 0)
      {
        int d = cbMap[i][j];
        DFS(cbMap, i, j, d);
        ++cbCount;
      }
    }
  }

  cout << count << " " << cbCount << endl;

  return 0;
}