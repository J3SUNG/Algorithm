#include <iostream>
#include <vector>
#include <string>
using namespace std;

int solution(string str1, string str2)
{
  vector<pair<string, bool>> s1;
  vector<pair<string, bool>> s2;
  double count = 0;
  int answer = 0;

  for (int i = 0; i < str1.length(); ++i)
  {
    str1[i] = tolower(str1[i]);
  }
  for (int i = 0; i < str2.length(); ++i)
  {
    str2[i] = tolower(str2[i]);
  }

  for (int i = 0; i < str1.length() - 1; ++i)
  {
    string temp = "";
    if (str1[i] >= 'a' && str1[i] <= 'z' && str1[i + 1] >= 'a' && str1[i + 1] <= 'z')
    {
      temp += str1[i];
      temp += str1[i + 1];
      s1.push_back({temp, false});
    }
  }
  for (int i = 0; i < str2.length() - 1; ++i)
  {
    string temp = "";
    if (str2[i] >= 'a' && str2[i] <= 'z' && str2[i + 1] >= 'a' && str2[i + 1] <= 'z')
    {
      temp += str2[i];
      temp += str2[i + 1];
      s2.push_back({temp, false});
    }
  }

  for (int i = 0; i < s1.size(); ++i)
  {
    for (int j = 0; j < s2.size(); ++j)
    {
      if (s1[i].second || s2[j].second)
      {
        continue;
      }
      if (s1[i].first == s2[j].first)
      {
        s1[i].second = true;
        s2[j].second = true;
        ++count;
      }
    }
  }

  if (s1.size() == 0 && s2.size() == 0)
  {
    return 65536;
  }

  answer = count / (s1.size() + s2.size() - count) * 65536;

  return answer;
}

int main(int argc, char *argv[])
{
  string str1 = "handshake";
  string str2 = "shake hands";

  solution(str1, str2);

  return 0;
}