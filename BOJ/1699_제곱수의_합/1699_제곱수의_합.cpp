#include <iostream>
#include <algorithm>
#define MAX 987654321
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int memo[100010] = {
      0,
  };
  cin >> n;

  for (int i = 1; i < 100010; ++i)
  {
    memo[i] = MAX;
  }
  for (int i = 1; i <= n; ++i)
  {
    if (i * i > n)
    {
      break;
    }
    int j = i * i;
    for (; j <= n; ++j)
    {
      memo[j] = min(memo[j], memo[j - (i * i)] + 1);
    }
  }
  cout << memo[n] << endl;
  return 0;
}