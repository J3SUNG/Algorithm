#include <iostream>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int num = 0;
  string s;

  cin >> s;

  for (int i = 0; i < s.length(); ++i)
  {
    num *= 16;

    if (s[i] >= 'A' && s[i] <= 'F')
    {
      num += s[i] - 'A' + 10;
    }
    else
    {
      num += s[i] - '0';
    }
  }
  cout << num << endl;

  return 0;
}