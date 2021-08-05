#include <iostream>
#include <string>
using namespace std;

string recursion(string w)
{
  string u, v;
  int l = 0;
  int r = 0;
  bool goodStr = w[0] == '(' ? true : false;

  if (w == "")
  {
    return "";
  }
  for (int i = 0; i < w.length(); ++i)
  {
    if (w[i] == '(')
    {
      ++l;
    }
    else
    {
      ++r;
    }

    if (l == r)
    {
      u = w.substr(0, i + 1);

      if (i < w.length() - 1)
      {
        v = w.substr(i + 1);
      }
      break;
    }
  }
  if (!goodStr)
  {
    string str = "(";
    str += recursion(v);
    str += ")";
    for (int i = 1; i < u.length() - 1; ++i)
    {
      if (u[i] == '(')
      {
        str += ')';
      }
      else
      {
        str += '(';
      }
    }
    return str;
  }
  else
  {
    u += recursion(v);
    return u;
  }
}

string solution(string p)
{
  string answer = "";
  answer = recursion(p);

  return answer;
}

int main(int argc, char *argv[])
{
  cout << solution(")()()()(") << endl;

  return 0;
}