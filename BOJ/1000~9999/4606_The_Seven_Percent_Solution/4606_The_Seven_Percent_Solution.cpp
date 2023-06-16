#include <iostream>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  bool flag;
  string s;
  string result;
  string arr[7] = {"%20", "%21", "%24", "%25", "%28", "%29", "%2a"};
  char c[7] = {' ', '!', '$', '%', '(', ')', '*'};

  while (1)
  {
    result = "";

    getline(cin, s);

    if (s == "#")
    {
      break;
    }

    for (int i = 0; i < s.length(); ++i)
    {
      flag = false;
      for (int j = 0; j < 7; ++j)
      {
        if (s[i] == c[j])
        {
          result += arr[j];
          flag = true;
          break;
        }
      }
      if (!flag)
      {
        result += s[i];
      }
    }

    cout << result << endl;
  }

  return 0;
}