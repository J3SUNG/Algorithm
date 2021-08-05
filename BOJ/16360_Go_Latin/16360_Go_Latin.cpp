#include <iostream>
using namespace std;

int n;
string s;
char e[12] = {'a', 'i', 'y', 'l', 'n', 'o', 'r', 't', 'u', 'v', 'w', 'e'};

void add(char c)
{
  if (c == 'e' && s[s.length() - 2] != 'n')
  {
    c = ' ';
  }

  switch (c)
  {
  case 'a':
    s += "s";
    break;
  case 'i':
    s += "os";
    break;
  case 'y':
    s[s.length() - 1] = 'i';
    s += "os";
    break;
  case 'l':
    s += "es";
    break;
  case 'n':
    s[s.length() - 1] = 'a';
    s += "nes";
    break;
  case 'o':
    s += "s";
    break;
  case 'r':
    s += "es";
    break;
  case 't':
    s += "as";
    break;
  case 'u':
    s += "s";
    break;
  case 'v':
    s += "es";
    break;
  case 'w':
    s += "as";
    break;
  case 'e':
    s[s.length() - 2] = 'a';
    s[s.length() - 1] = 'n';
    s += "es";
    break;
  default:
    s += "us";
    break;
  }
}

int main(int argc, char *argv[])
{
  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> s;
    add(s[s.length() - 1]);
    cout << s << endl;
  }

  return 0;
}