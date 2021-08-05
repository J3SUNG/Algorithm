#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  string s;
  int alp[30];
  int index;

  cin >> s;

  for (int i = 0; i < 26; ++i)
  {
    alp[i] = -1;
  }

  for (int i = 0; i < s.length(); ++i)
  {
    index = s[i] - 97;
    if (alp[index] == -1)
    {
      alp[index] = i;
    }
  }

  for (int i = 0; i < 26; ++i)
  {
    cout << alp[i] << " ";
  }

  return 0;
}