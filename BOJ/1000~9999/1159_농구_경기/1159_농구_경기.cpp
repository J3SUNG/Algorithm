#include <iostream>
#include <cstring>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int chk = 0;
  int n;
  int c[26];
  string s;

  memset(c, 0, sizeof(c));

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> s;
    int index = s[0] - 97;
    c[index]++;
  }

  for (int i = 0; i < 26; ++i)
  {
    if (c[i] >= 5)
    {
      cout << (char)(i + 97);
      chk = 1;
    }
  }
  if (chk == 0)
  {
    cout << "PREDAJA";
  }

  return 0;
}