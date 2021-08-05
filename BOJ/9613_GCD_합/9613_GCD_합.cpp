#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>
using namespace std;

int gcd(int a, int b)
{
  if (b == 0)
  {
    return a;
  }
  else
  {
    return gcd(b, a % b);
  }
}

int main(int argc, char *argv[])
{
  int ts;
  int n;
  int num;
  long long result;
  vector<int> v;

  cin >> ts;

  while (ts--)
  {
    result = 0;

    cin >> n;

    for (int i = 0; i < n; ++i)
    {
      cin >> num;
      v.push_back(num);
    }

    for (int i = 0; i < n; ++i)
    {
      for (int j = i + 1; j < n; ++j)
      {
        result += gcd(v[i], v[j]);
      }
    }
    v.clear();
    cout << result << endl;
  }

  return 0;
}