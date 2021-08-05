#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

typedef long long ll;
int DP[1000001];

int main(int argc, char *argv[])
{
  int ts;
  ll num;
  ll maxNum = 0;
  vector<ll> v;

  memset(DP, 0, sizeof(DP));

  cin >> ts;

  while (ts--)
  {
    cin >> num;
    v.push_back(num);

    maxNum = max(maxNum, num);
  }

  DP[1] = 1;
  DP[2] = 2;
  DP[3] = 4;

  for (int i = 4; i <= maxNum; ++i)
  {
    DP[i] = (((DP[i - 1] + DP[i - 2]) % 1000000009) + DP[i - 3]) % 1000000009;
  }

  for (int i = 0; i < v.size(); ++i)
  {
    cout << DP[v[i]] << endl;
  }

  return 0;
}