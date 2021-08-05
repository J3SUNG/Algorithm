#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int alp[26];
  string s;
  int maxNum = -1;
  int maxIndex = 0;
  int count = 0;

  memset(alp, 0, sizeof(alp));

  cin >> s;

  for (int i = 0; i < s.size(); i++)
  {
    s[i] = toupper(s[i]);
    int index = s[i] - 65;
    ++alp[index];
  }

  for (int i = 0; i < 26; i++)
  {
    if (maxNum < alp[i])
    {
      maxNum = alp[i];
      maxIndex = i;
      count = 0;
    }
    else if (maxNum == alp[i])
    {
      ++count;
    }
  }

  if (count > 0)
  {
    cout << "?" << endl;
  }
  else
  {
    cout << (char)(maxIndex + 65) << endl;
  }

  return 0;
}