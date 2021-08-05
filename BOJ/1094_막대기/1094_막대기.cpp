#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n = 64;
  int sum = 0;
  int find;
  vector<int> v;

  cin >> find;

  while (1)
  {
    if (n + sum == find)
    {
      v.push_back(n);
      sum += n;
      break;
    }
    else if (n + sum < find)
    {
      v.push_back(n);
      sum += n;
      n /= 2;
    }
    else if (n + sum > find)
    {
      n /= 2;
    }
  }

  cout << v.size() << endl;

  return 0;
}