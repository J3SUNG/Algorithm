#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  string s;

  cin >> s;

  for (int i = 0; i < s.length(); ++i)
  {
    s[i] = s[i] - 3;
    if (s[i] < 65)
    {
      s[i] += 26;
    }
    
    cout << s[i];
  }

  return 0;
}