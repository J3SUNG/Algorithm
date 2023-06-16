#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  string s;
  int flag;
  int i = 0;
  int zero = 0;
  int one = 0;

  cin >> s;

  flag = -1;
  for (int j = 0; j < s.length(); ++j)
  {
    if (flag != 0 && s[j] == '0')
    {
      flag = 0;
      ++zero;
    }
    else if (flag != 1 && s[j] == '1')
    {
      flag = 1;
      ++one;
    }
  }

  cout << min(zero, one) << endl;

  return 0;
}