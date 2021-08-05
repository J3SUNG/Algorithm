#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int GCD(int a, int b)
{
  if (a % b == 0)
  {
    return b;
  }

  return GCD(b, a % b);
}

int main(void)
{
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  int N;
  int x;
  vector<int> v;
  vector<int> num;

  cin >> N;

  for (int i = 0; i < N; i++)
  {
    cin >> x;
    v.push_back(x);
  }

  sort(v.begin(), v.end());

  int gcd = v[1] - v[0];
  for (int i = 2; i < N; i++)
  {
    gcd = GCD(gcd, v[i] - v[i - 1]);
  }

  for (int i = 2; i * i <= gcd; i++)
  {
    if (gcd % i == 0)
    {
      num.push_back(i);
      num.push_back(gcd / i);
    }
  }

  num.push_back(gcd);
  sort(num.begin(), num.end());
  num.erase(unique(num.begin(), num.end()), num.end());

  for (int i = 0; i < num.size(); i++)
  {
    cout << num[i] << " ";
  }

  cout << "\n";

  return 0;
}