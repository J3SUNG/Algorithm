#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int map[1010][1010];
int moveX[3] = {0, -1, -1};
int moveY[3] = {-1, 0, -1};

int main(int argc, char *argv[])
{
  int maxNum = 0;
  string s1;
  string s2;

  cin >> s1;
  cin >> s2;

  int width = s1.length();
  int height = s2.length();
  for (int i = 0; i <= width; ++i)
  {
    for (int j = 0; j <= height; ++j)
    {
      map[i][j] = 0;
    }
  }

  for (int i = 1; i <= width; ++i)
  {
    for (int j = 1; j <= height; ++j)
    {
      if (s1.substr(i - 1, 1) == (s2.substr(j - 1, 1)))
      {
        map[i][j] = -1;
      }
    }
  }

  for (int i = 1; i <= width; ++i)
  {
    for (int j = 1; j <= height; ++j)
    {
      maxNum = 0;
      for (int k = 0; k < 3; ++k)
      {
        int x = i + moveX[k];
        int y = j + moveY[k];
        maxNum = max(maxNum, map[x][y]);
      }
      if (map[i][j] == -1)
      { // s1, s2 같은 문자일때
        map[i][j] = map[i - 1][j - 1] + 1;
      }
      else
      { // 그 외
        map[i][j] = maxNum;
      }
    }
  }

  cout << map[width][height] << endl;

  return 0;
}