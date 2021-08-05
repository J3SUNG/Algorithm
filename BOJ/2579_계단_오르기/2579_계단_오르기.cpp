#include <iostream>
using namespace std;

int stair[200];
int memo[200][3];

void init()
{
  for (int j = 0; j < 3; ++j)
  {
    for (int i = 0; i < 200; ++i)
    {
      memo[i][j] = 0;
    }
  }
  for (int i = 0; i < 200; ++i)
  {
    stair[i] = 0;
  }
}

int main(int argc, char *argv[])
{
  int cycle;
  cin >> cycle;
  init();
  for (int i = 0; i < cycle; ++i)
  {
    cin >> stair[i];
  }
  memo[0][1] = stair[0];
  memo[1][1] = stair[1];
  memo[1][2] = stair[0] + stair[1];
  for (int i = 2; i < cycle; ++i)
  {
    memo[i][1] = max(memo[i - 2][1], memo[i - 2][2]) + stair[i];
    memo[i][2] = memo[i - 1][1] + stair[i];
  }
  cout << max(memo[cycle - 1][1], memo[cycle - 1][2]);
  return 0;
}
