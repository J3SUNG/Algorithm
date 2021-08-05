#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#define MAX 987654321
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int minNum;
  int DP[50010];
  vector<int> v;

  memset(DP, 0, sizeof(DP));

  cin >> n;

  DP[0] = 0;
  DP[1] = 1;

  for (int i = 1; i < 230; ++i)
  {
    v.push_back(i * i);
  }

  for (int i = 2; i <= n; ++i)
  {
    minNum = MAX;

    for (int j = 0; v[j] <= i; ++j)
    {
      int tmp = i - v[j];
      minNum = min(minNum, DP[tmp]);
    }

    DP[i] = minNum + 1;
  }

  cout << DP[n] << endl;

  return 0;
}