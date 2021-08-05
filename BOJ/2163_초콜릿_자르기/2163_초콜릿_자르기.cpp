#include <iostream>
using namespace std;

int choco(int num, int memo[])
{
  if (num == 1)
  {
    return 0;
  }
  if (memo[num] != 0)
  {
    return memo[num];
  }
  if (num % 2 == 0)
  {
    memo[num] = (choco(num / 2, memo) * 2) + 1;
  }
  else
  {
    memo[num] = choco(num / 2, memo) + choco(num / 2 + 1, memo) + 1;
  }
  return memo[num];
}
void init(int memo[])
{
  for (int i = 0; i < 100; i++)
  {
    memo[i] = 0;
  }
}
int main(void)
{
  int memo[100000];
  int num;
  int x, y;
  int value;
  init(memo);
  cin >> x;
  cin >> y;
  num = x * y;
  value = choco(num, memo);
  cout << value << endl;

  return 0;
}