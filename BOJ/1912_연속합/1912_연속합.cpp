#include <iostream>
#include <algorithm>
using namespace std;

int memo[100010];
int num[100010];
void init()
{
  for (int i = 0; i < 10010; ++i)
  {
    num[i] = 0;
    memo[i] = 0;
  }
}

int main(int argc, char *argv[])
{
  init();
  int n;
  int maxNum = -987654321;

  cin >> n;
  for (int i = 0; i < n; ++i)
  {
    cin >> num[i];
  }
  memo[0] = num[0];
  for (int i = 1; i < n; ++i)
  {
    memo[i] = max(memo[i - 1] + num[i], num[i]);
  }
  for (int i = 0; i < n; ++i)
  {
    if (memo[i] > maxNum)
    {
      maxNum = memo[i];
    }
  }
  cout << maxNum;
  return 0;
}