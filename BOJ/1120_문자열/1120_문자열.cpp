#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int sub;
  int count;
  int result = 0;
  string s1;
  string s2;

  cin >> s1 >> s2;

  sub = s2.length() - s1.length();

  for (int i = 0; i <= sub; ++i)
  {
    count = 0;
    for (int j = 0; j < s1.length(); ++j)
    {
      if (s1[j] == s2[j + i])
      {
        ++count;
      }
    }
    result = max(result, count);
  }
  result += sub;
  result = s2.length() - result;

  cout << result << endl;

  return 0;
}