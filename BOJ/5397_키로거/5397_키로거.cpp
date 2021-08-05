#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <queue>
#include <stack>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int ts;
  string str;
  stack<char> a;
  stack<char> b;
  vector<char> result;

  cin >> ts;

  while (ts--)
  {
    result.clear();

    cin >> str;

    for (int i = 0; i < str.length(); ++i)
    {
      if (str[i] == '-')
      {
        if (!a.empty())
        {
          a.pop();
        }
      }
      else if (str[i] == '<')
      {
        if (!a.empty())
        {
          b.push(a.top());
          a.pop();
        }
      }
      else if (str[i] == '>')
      {
        if (!b.empty())
        {
          a.push(b.top());
          b.pop();
        }
      }
      else
      {
        a.push(str[i]);
      }
    }

    while (!b.empty())
    {
      a.push(b.top());
      b.pop();
    }
    while (!a.empty())
    {
      result.push_back(a.top());
      a.pop();
    }
    reverse(result.begin(), result.end());

    for (int i = 0; i < result.size(); ++i)
    {
      cout << result[i];
    }
    cout << endl;
  }

  return 0;
}