#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int c[3];
int map[3000][3000];

void divCon(int n, int m, int x)
{
  int check = map[n][m];

  for (int i = n; i < n + x; ++i)
  {
    for (int j = m; j < m + x; ++j)
    {
      if (check == -1 && map[i][j] != -1)
      {
        check = 2;
      }
      else if (check == 0 && map[i][j] != 0)
      {
        check = 2;
      }
      else if (check == 1 && map[i][j] != 1)
      {
        check = 2;
      }
      if (check == 2)
      {
        int div = x / 3;
        divCon(n, m, div);
        divCon(n + div, m, div);
        divCon(n + div * 2, m, div);

        divCon(n, m + div, div);
        divCon(n + div, m + div, div);
        divCon(n + div * 2, m + div, div);

        divCon(n, m + div * 2, div);
        divCon(n + div, m + div * 2, div);
        divCon(n + div * 2, m + div * 2, div);
        return;
      }
    }
  }

  if (check == -1)
  {
    ++c[0];
  }
  else if (check == 0)
  {
    ++c[1];
  }
  else if (check == 1)
  {
    ++c[2];
  }

  return;
}

int main(int argc, char *argv[])
{
  int n;

  cin >> n;

  memset(map, 0, sizeof(map));
  memset(c, 0, sizeof(c));
  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      cin >> map[i][j];
    }
  }

  divCon(0, 0, n);

  cout << c[0] << endl;
  cout << c[1] << endl;
  cout << c[2] << endl;

  return 0;
}