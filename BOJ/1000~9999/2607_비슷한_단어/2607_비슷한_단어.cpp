#include <iostream>
#include <cstring>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int index = 0;
  int count = 0;
  int dif = 0;
  int flag = 0;
  int xc;
  int yc;
  int alp[30];
  int comp[30];
  string s;

  memset(alp, 0, sizeof(alp));

  cin >> n;
  cin >> s;

  for (int i = 0; i < s.length(); ++i)
  {
    index = s[i] - 65;
    ++alp[index];
  }
  --n;

  while (n--)
  {
    memset(comp, 0, sizeof(comp));
    dif = 0;
    flag = 0;
    xc = 0;
    yc = 0;

    cin >> s;

    for (int i = 0; i < s.length(); ++i)
    {
      index = s[i] - 65;
      ++comp[index];
    }
    for (int i = 0; i < 26; ++i)
    {
      if (alp[i] == comp[i])
      {
        continue;
      }
      if (abs(alp[i] - comp[i]) > 1)
      { // 2이상차이
        flag = 1;
        break;
      }
      else if (alp[i] < comp[i])
      {
        ++xc;
      }
      else if (alp[i] > comp[i])
      {
        ++yc;
      }
      if (xc > 1 || yc > 1)
      {
        flag = 1;
        break;
      }
    }
    if (flag == 1)
    {
      continue;
    }
    ++count;
  }

  cout << count << endl;

  return 0;
}