#include <iostream>
#include <cstring>
#include <stack>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  bool flag;
  string str;
  stack<char> s;

  while (1)
  {
    flag = false;

    while (!s.empty())
    {
      s.pop();
    }

    getline(cin, str);

    if (str == ".")
    {
      break;
    }

    for (int i = 0; i < str.length(); ++i)
    {
      if (str[i] == '(' || str[i] == '[')
      {
        s.push(str[i]);
      }
      else if (str[i] == ')')
      {
        if (!s.empty() && s.top() == '(')
        {
          s.pop();
        }
        else
        {
          flag = true;
          break;
        }
      }
      else if (str[i] == ']')
      {
        if (!s.empty() && s.top() == '[')
        {
          s.pop();
        }
        else
        {
          flag = true;
          break;
        }
      }
    }
    if (!s.empty() || flag == true)
    {
      cout << "no" << endl;
    }
    else
    {
      cout << "yes" << endl;
    }
  }

  return 0;
}