#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

string solution(string s)
{
  string answer = "";
  bool checkDot = true;

  for (int i = 0; i < s.length(); ++i)
  {
    s[i] = tolower(s[i]);
  }

  for (int i = 0; i < s.length(); ++i)
  {
    if ((s[i] >= 48 && s[i] <= 57) || (s[i] >= 65 && s[i] <= 90) || (s[i] >= 97 && s[i] <= 122) || s[i] == '.' || s[i] == '_' || s[i] == '-')
    {
      if (checkDot && s[i] == '.')
      {
        continue;
      }
      if ((i == 0 || i == s.length() - 1) && s[i] == '.')
      {
        checkDot = true;
        continue;
      }
      if (s[i] == '.')
      {
        checkDot = true;
      }
      else
      {
        checkDot = false;
      }
      answer += s[i];
    }
  }

  if (answer.length() > 15)
  {
    answer = answer.substr(0, 15);
  }
  if (answer[answer.length() - 1] == '.')
  {
    answer = answer.substr(0, answer.length() - 1);
  }
  if (answer.length() == 0)
  {
    answer = "a";
  }
  while (answer.length() < 3)
  {
    answer += answer[answer.length() - 1];
  }

  return answer;
}

int main(int argc, char *argv[])
{
  string s;
  bool check = false;

  cin >> s;

  s = solution(s);

  cout << s << endl;

  return 0;
}