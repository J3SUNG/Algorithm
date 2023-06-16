#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int coinNum;
  int findCoin;
  int coin[10010] = {
      0,
  };
  int memo[100010] = {
      0,
  };
  cin >> coinNum;
  cin >> findCoin;

  for (int i = 1; i <= coinNum; ++i)
  {
    cin >> coin[i];
  }

  for (int i = 1; i <= coinNum; ++i)
  {
    int j = coin[i] + 1;
    memo[coin[i]] = 1;
    for (; j <= findCoin; ++j)
    {
      if (memo[j - coin[i]] == 0)
      {
        continue;
      }
      if (memo[j] == 0)
      {
        memo[j] = memo[j - coin[i]] + 1;
      }
      memo[j] = min(memo[j], memo[j - coin[i]] + 1);
    }
  }
  if (memo[findCoin] == 0)
  {
    cout << "-1" << endl;
  }
  else
  {
    cout << memo[findCoin] << endl;
  }

  return 0;
}