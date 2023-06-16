#include <iostream>
#include <string>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int alpha[26];
  string s;

  memset(alpha, 0, sizeof(alpha));

  cin >> s;

  for (int i = 0; i < s.length(); ++i)
  {
    ++alpha[s[i] - 97];
  }

  for (int i = 0; i < 26; ++i)
  {
    cout << alpha[i] << " ";
  }

  return 0;
}