#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int main(int argc, char *argv[])
{
  bool flag;
  char v[5] = {'a', 'i', 'o', 'e', 'u'};
  string s;
  string result;

  while (1)
  {
    flag = false;
    result = "";

    cin >> s;

    if (s == "#")
    {
      return 0;
    }

    for (int i = 0; i < s.length(); ++i)
    {
      for (int j = 0; j < 5; ++j)
      {
        if (s[i] == v[j])
        {
          flag = true;
          break;
        }
      }
      if (flag)
      {
        result = s.substr(i, s.length() - i) + s.substr(0, i);
        break;
      }
    }
    result += "ay";

    if (flag)
    {
      cout << result << endl;
    }
    else
    {
      cout << s + "ay" << endl;
    }
  }

  return 0;
}