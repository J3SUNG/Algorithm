#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int t;
  int num;
  string s;

  cin >> t;

  while (t--)
  {
    cin >> num;
    cin >> s;

    for (int i = 0; i < s.length(); ++i)
    {
      for (int j = 0; j < num; ++j)
      {
        cout << s[i];
      }
    }
    cout << endl;
  }

  return 0;
}