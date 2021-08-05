#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

vector<int> solution(string msg)
{
  int k;
  int len = 1;
  int textLen;
  int maxRange;
  char alp;
  bool check;
  bool exist;
  string s = " ";
  string text;
  string mixText;
  vector<int> answer;
  vector<pair<int, string>> dic;

  for (int i = 1; i <= 26; ++i)
  {
    alp = 'A' + i - 1;
    s = alp;
    dic.push_back(make_pair(i, s));
  }

  for (int i = 0; i < msg.length();)
  {
    check = false;
    for (int j = 0; j < len; ++j)
    {
      if (i + len > msg.length() + j)
      {
        maxRange = i + len - j - msg.length();
        text = msg.substr(i, len - maxRange);
      }
      else
      {
        text = msg.substr(i, len - j);
      }
      for (k = 0; k < dic.size(); ++k)
      {
        if (text == dic[k].second)
        {
          answer.push_back(dic[k].first);
          check = true;
          break;
        }
      }
      if (check)
      {
        break;
      }
    }
    if (check)
    {
      i += dic[k].second.length();
      if (i >= msg.length())
      {
        break;
      }
      exist = false;
      mixText = dic[k].second + msg[i];
      for (int l = 0; l < dic.size(); ++l)
      {
        if (mixText == dic[l].second)
        {
          exist = true;
        }
      }
      if (!exist)
      {
        dic.push_back({dic.size() + 1, mixText});
        textLen = mixText.length();
        len = max(len, textLen);
      }
      continue;
    }
  }
  return answer;
}

int main(int argc, char *argv[])
{
  solution("THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS");

  return 0;
}