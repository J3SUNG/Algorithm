#include <iostream>
using namespace std;

int memo[10010];
int coin[10010];

void init()
{
  for (int i = 0; i < 10010; ++i)
  {
    memo[i] = 0;
    coin[i] = 0;
  }
}

int main(int argc, char *argv[])
{
  init();
  int coinNum = 0;
  int findCoin;
  memo[0] = 1;
  cin >> coinNum;
  cin >> findCoin;
  for (int j = 0; j < coinNum; ++j)
  {
    cin >> coin[j];
  }
  for (int k = 0; k < coinNum; ++k)
  {
    for (int j = coin[k]; j <= findCoin; ++j)
    {
      memo[j] += memo[j - coin[k]];
    }
  }
  cout << memo[findCoin] << endl;
  return 0;
}