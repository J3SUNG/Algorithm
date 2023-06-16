#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int main(int argc, char *argv[])
{
  int x, y;
  char map[40][40];
  string s1;
  string s2;

  memset(map, '.', sizeof(map));

  cin >> s1;
  cin >> s2;

  for (int i = 0; i < s1.length(); ++i)
  {
    if (s2.find(s1[i]) <= s2.length())
    {
      x = s2.find(s1[i]);
      y = i;
      break;
    }
  }

  for (int i = 0; i < s2.length(); ++i)
  {
    for (int j = 0; j < s1.length(); ++j)
    {
      if (x == i)
      {
        map[i][j] = s1[j];
      }
      if (y == j)
      {
        map[i][j] = s2[i];
      }
      cout << map[i][j];
    }
    cout << endl;
  }

  return 0;
}