#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  string s;
  string s2;

  cin >> s;

  s2 = s[0];

  for (int i = 0; i < s.length(); ++i)
  {
    if (s[i] == '-')
    {
      s2 += s[i + 1];
    }
  }

  cout << s2 << endl;

  return 0;
}