#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int i = 0;
  vector<int> v;

  cin >> n;

  while (1)
  {
    v.push_back(n % 10);
    n /= 10;
    ++i;
    if (n == 0)
    {
      break;
    }
  }

  sort(v.begin(), v.end(), greater<int>());

  for (int j = 0; j < i; ++j)
  {
    cout << v[j];
  }

  return 0;
}