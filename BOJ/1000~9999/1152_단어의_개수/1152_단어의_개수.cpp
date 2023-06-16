#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int chk = 0;
  int count = 0;
  string s;

  getline(cin, s);

  for (int i = 0; i < s.length(); ++i)
  {
    if ((int)s[i] == 32)
    {
      chk = 0;
    }
    if ((int)s[i] != 32 && chk == 0)
    {
      ++count;
      chk = 1;
    }
  }

  cout << count << endl;

  return 0;
}