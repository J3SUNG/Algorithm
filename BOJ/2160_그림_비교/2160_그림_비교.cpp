#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#define MAX 987654321

using namespace std;

int main(int argc, char *argv[])
{
  bool flag;
  int n;
  int count;
  int x, y;
  int result = MAX;
  char map[5][7][50];
  string s;

  memset(map, 0, sizeof(map));

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < 5; ++j)
    {
      cin >> s;
      for (int k = 0; k < 7; ++k)
      {
        map[j][k][i] = s[k];
      }
    }
  }

  for (int i = 0; i < n; ++i)
  {
    for (int j = i + 1; j < n; ++j)
    {
      if (i == j)
      {
        continue;
      }
      flag = false;
      count = 0;
      for (int k = 0; k < 5; ++k)
      {
        for (int l = 0; l < 7; ++l)
        {
          if (map[k][l][i] != map[k][l][j])
          {
            ++count;
          }
          if (count > result)
          {
            flag = true;
            break;
          }
        }
        if (flag)
        {
          break;
        }
      }
      if (result > count)
      {
        result = count;
        x = i;
        y = j;
      }
    }
  }

  cout << x + 1 << " " << y + 1 << endl;

  return 0;
}