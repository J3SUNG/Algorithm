#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int map[130][130];

void divCon(int ns, int ms, int ne, int me)
{
  int check = map[ns][ms];

  for (int i = ns; i < ne; ++i)
  {
    for (int j = ms; j < me; ++j)
    {
      if (check == 0 && map[i][j] == 1)
      {
        check = 2;
      }
      else if (check == 1 && map[i][j] == 0)
      {
        check = 2;
      }
      if (check == 2)
      {
        cout << "(";
        divCon(ns, ms, (ns + ne) / 2, (ms + me) / 2);
        divCon(ns, (ms + me) / 2, (ns + ne) / 2, me);
        divCon((ns + ne) / 2, ms, ne, (ms + me) / 2);
        divCon((ns + ne) / 2, (ms + me) / 2, ne, me);
        cout << ")";
        return;
      }
    }
  }

  cout << check;

  return;
}

int main(int argc, char *argv[])
{
  int n;
  string s;

  cin >> n;

  memset(map, 0, sizeof(map));

  for (int i = 0; i < n; ++i)
  {
    cin >> s;
    for (int j = 0; j < n; ++j)
    {
      map[i][j] = s[j] - '0';
    }
  }

  divCon(0, 0, n, n);

  return 0;
}