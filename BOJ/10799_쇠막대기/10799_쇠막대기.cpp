#include <iostream>
#include <algorithm>
#include <string>
#include <stack>
using namespace std;

int main(int argc, char *argv[])
{
  string str;
  stack<int> s;
  int count = 0;
  cin >> str;

  for (int i = 0; i < str.length(); ++i)
  {
    if (str[i] == '(')
    {
      s.push(str[i]);
    }
    else
    {
      s.pop();
      if (str[i - 1] == '(')
      {
        count += s.size();
      }
      else
      {
        ++count;
      }
    }
  }

  cout << count << endl;

  return 0;
}