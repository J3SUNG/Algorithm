#include <iostream>
#include <cstring>
#include <stack>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  bool flag;
  string str;
  stack<char> s;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    flag = false;

    while (!s.empty())
    {
      s.pop();
    }

    cin >> str;

    for (int j = 0; j < str.size(); ++j)
    {
      if (str[j] == ')')
      {
        if (!s.empty() && s.top() == '(')
        {
          s.pop();
        }
        else
        {
          cout << "NO" << endl;
          flag = true;
          break;
        }
      }
      else
      {
        s.push(str[j]);
      }
    }
    if (!s.empty())
    {
      cout << "NO" << endl;
      flag = true;
    }
    if (flag == false)
    {
      cout << "YES" << endl;
    }
  }

  return 0;
}