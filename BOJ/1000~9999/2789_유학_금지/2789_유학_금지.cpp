#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  char *p;
  string s;
  char c[9] = {'C', 'A', 'M', 'B', 'R', 'I', 'D', 'G', 'E'};

  cin >> s;

  for (int i = 0; i < s.length(); ++i)
  {
    p = find(c, c + 9, s[i]);
    if (p == c + 9)
    {
      cout << s[i];
    }
  }
  cout << endl;

  return 0;
}