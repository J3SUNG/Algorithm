#include <iostream>
#include <cstring>
using namespace std;

int map[510][510];
int memo[510][510];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};
int M, N;

int search(int i, int j)
{
  if (i == M && j == N)
  {
    return 1;
  }
  int &result = memo[i][j];

  if (result != -1)
  {
    return result;
  }
  result = 0;

  for (int k = 0; k < 4; ++k)
  {
    int x = i + moveX[k];
    int y = j + moveY[k];
    if (map[x][y] < map[i][j] && x > 0 && x <= M && y > 0 && y <= N)
    {
      result += search(x, y);
    }
  }

  return result;
}

int main(void)
{
  cin >> M >> N;
  for (int i = 1; i <= M; i++)
  {
    for (int j = 1; j <= N; j++)
    {
      cin >> map[i][j];
    }
  }

  memset(memo, -1, sizeof(memo));
  cout << search(1, 1) << endl;
  return 0;
}