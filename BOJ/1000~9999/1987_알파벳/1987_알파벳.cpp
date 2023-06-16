#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int R, C;
int result = 0;
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};
int visit[26];
char map[30][30];

void solve(int a, int b, int c)
{
  int index;
  index = map[a][b] - 65;

  if (visit[index])
  {
    return;
  }

  visit[index] = 1;
  ++c;
  result = max(result, c);

  for (int i = 0; i < 4; ++i)
  {
    int x = a + moveX[i];
    int y = b + moveY[i];

    if (x >= 0 && y >= 0 && x < R && y < C)
    {
      solve(x, y, c);
    }
  }
  visit[index] = 0;
}

int main(int argc, char *argv[])
{
  string s;

  memset(map, 0, sizeof(map));
  memset(visit, 0, sizeof(visit));

  cin >> R >> C;

  for (int i = 0; i < R; ++i)
  {
    cin >> s;
    for (int j = 0; j < C; ++j)
    {
      map[i][j] = s[j];
    }
  }

  solve(0, 0, 0);

  cout << result << endl;

  return 0;
}