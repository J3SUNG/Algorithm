#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int count = 0;
  int chk[110];
  string arr[8] = {"c=", "c-", "d-", "lj", "nj", "s=", "z=", "dz="};
  string s;

  memset(chk, 0, sizeof(chk));

  cin >> s;

  for (int i = 0; i < s.length(); ++i)
  {
    for (int j = 0; j < 8; ++j)
    {
      if (arr[j] == s.substr(i, 2))
      {
        chk[i] = 1;
        chk[i + 1] = 1;
        ++count;
      }
    }
    if (arr[7] == s.substr(i, 3))
    {
      chk[i] = 1;
    }
  }
  for (int i = 0; i < s.length(); ++i)
  {
    if (chk[i] == 0)
    {
      ++count;
    }
  }

  cout << count << endl;

  return 0;
}