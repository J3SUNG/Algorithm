#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int main(int argc, char *argv[])
{
  int m, n;
  int i = 0;
  int num = 0;
  int sum = 0;
  vector<int> v;

  cin >> m >> n;

  while (1)
  {
    num = pow(i, 2);
    if (num > n)
    {
      break;
    }
    if (num >= m)
    {
      v.push_back(num);
      sum += num;
    }
    ++i;
  }

  if (v.size() == 0)
  {
    cout << "-1" << endl;
  }
  else
  {
    cout << sum << endl;
    cout << v[0] << endl;
  }

  return 0;
}