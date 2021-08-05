#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  string s;
  string c;
  int t;
  int sum;
  int count;

  cin >> t;

  while (t--)
  {
    sum = 0;
    count = 1;

    cin >> s;

    for (int i = 0; i < s.length(); ++i)
    {
      c = s.substr(i, 1);

      if (c == "O")
      {
        sum += count;
        ++count;
      }
      else
      {
        count = 1;
      }
    }

    cout << sum << endl;
  }

  return 0;
}