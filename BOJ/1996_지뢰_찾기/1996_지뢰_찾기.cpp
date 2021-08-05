#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#define MAX 987654321

using namespace std;

int n;
char input[1010][1010];
int map[1010][1010];
int moveX[8] = {-1, -1, -1, 0, 0, 1, 1, 1};
int moveY[8] = {-1, 0, 1, -1, 1, -1, 0, 1};
string s;

int main(int argc, char *argv[])
{
  cin >> n;

  memset(map, 0, sizeof(map));

  for (int i = 1; i <= n; ++i)
  {
    cin >> s;
    for (int j = 1; j <= n; ++j)
    {
      input[i][j] = s[j - 1];
    }
  }

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= n; ++j)
    {
      for (int k = 0; k < 8; ++k)
      {
        int x = i + moveX[k];
        int y = j + moveY[k];

        if (input[x][y] != '.')
        {
          continue;
        }
        if (input[i][j] < '0' || input[i][j] > '9')
        {
          continue;
        }
        map[x][y] += input[i][j] - '0';
      }
    }
  }

  for (int i = 1; i <= n; ++i)
  {
    for (int j = 1; j <= n; ++j)
    {
      if (input[i][j] != '.')
      {
        cout << "*";
        continue;
      }
      if (map[i][j] > 9)
      {
        cout << "M";
        continue;
      }
      cout << map[i][j];
    }
    cout << endl;
  }

  return 0;
}