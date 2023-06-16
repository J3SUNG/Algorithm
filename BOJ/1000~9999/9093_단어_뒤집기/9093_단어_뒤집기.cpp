#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int n = 10;
  int start, end;
  string s;
  string temp;

  cin >> n;

  getline(cin, s);
  while (n--)
  {
    end = 0;
    start = 0;
    getline(cin, s);

    for (int i = 0; i <= s.length(); ++i)
    {
      if (s[i] == ' ' || i == s.length())
      {
        temp = s.substr(start, end);
        reverse(temp.begin(), temp.end());
        cout << temp << " ";
        start = i + 1;
        end = -1;
      }
      ++end;
    }
    cout << "\n";
  }

  return 0;
}