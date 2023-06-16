#include <iostream>
#include <cstring>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  bool flag = false;
  bool map[6][6];
  int start[2];
  int prev[2];
  string s;

  cin >> s;

  prev[0] = s[0] - 'A';
  prev[1] = s[1] - '1';
  start[0] = prev[0];
  start[1] = prev[1];

  memset(map, false, sizeof(map));

  for (int i = 1; i < 37; ++i)
  {
    int now[2];

    if (i == 36)
    {
      now[0] = start[0];
      now[1] = start[1];
    }
    else
    {
      cin >> s;

      now[0] = s[0] - 'A';
      now[1] = s[1] - '1';
    }

    if (!map[now[0]][now[1]] && ((abs(now[0] - prev[0]) == 1 && abs(now[1] - prev[1]) == 2) || (abs(now[0] - prev[0]) == 2 && abs(now[1] - prev[1]) == 1)))
    {
      map[now[0]][now[1]] = true;
      prev[0] = now[0];
      prev[1] = now[1];
    }
    else
    {
      flag = true;
      break;
    }
  }

  if (flag)
  {
    cout << "Invalid" << endl;
  }
  else
  {
    cout << "Valid" << endl;
  }

  return 0;
}