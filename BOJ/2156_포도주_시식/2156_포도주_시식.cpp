#include <iostream>
#include <algorithm>
using namespace std;

int memo[10010];
int drink[10010];
void init()
{
  for (int i = 0; i < 10010; ++i)
  {
    drink[i] = 0;
    memo[i] = 0;
  }
}

int main(int argc, char *argv[])
{
  init();
  int n;
  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> drink[i];
  }
  memo[0] = drink[0];
  memo[1] = drink[0] + drink[1];
  for (int i = 2; i < n; ++i)
  {
    memo[i] = max(memo[i - 1], max(memo[i - 2] + drink[i], memo[i - 3] + drink[i - 1] + drink[i]));
  }

  cout << memo[n - 1];
  return 0;
}