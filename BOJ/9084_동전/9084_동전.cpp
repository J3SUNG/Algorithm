#include <iostream>
using namespace std;

int coin[20];
int memo[10001];

void init()
{
  for (int i = 0; i < 20; ++i)
  {
    coin[i] = 0;
  }
  for (int i = 0; i < 10001; ++i)
  {
    memo[i] = 0;
  }
  memo[0] = 1;
}

int main(int argc, char *argv[])
{
  int cycle;
  int coinNum = 0;
  int findCoin;
  cin >> cycle;
  for (int i = 0; i < cycle; ++i)
  {
    init();
    cin >> coinNum;
    for (int j = 0; j < coinNum; ++j)
    {
      cin >> coin[j];
    }
    cin >> findCoin;
    for (int k = 0; k < coinNum; ++k)
    {
      for (int j = coin[k]; j <= findCoin; ++j)
      {
        memo[j] += memo[j - coin[k]];
      }
    }
    cout << memo[findCoin] << endl;
  }

  return 0;
}