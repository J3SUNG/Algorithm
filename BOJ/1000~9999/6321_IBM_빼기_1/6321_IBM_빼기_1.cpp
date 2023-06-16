#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int ts;
  string s;

  cin >> ts;

  for (int i = 1; i <= ts; ++i)
  {
    cin >> s;
    cout << "String #" << i << "\n";
    for (int j = 0; j < s.length(); ++j)
    {
      cout << (char)((s[j] - 'A' + 1) % 26 + 'A');
    }
    cout << "\n\n";
  }

  return 0;
}