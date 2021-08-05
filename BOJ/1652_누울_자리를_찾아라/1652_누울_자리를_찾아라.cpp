#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int n;
int countM;
int countN;
char map[110][110];
string s;

void checkM(int x)
{
  bool flag = false;
  for (int i = 0; i < n; ++i)
  {
    if (!flag && map[i][x] == '.' && map[i + 1][x] == '.')
    {
      ++countM;
      flag = true;
    }
    if (flag && map[i][x] == 'X')
    {
      flag = false;
    }
  }
}

void checkN(int x)
{
  bool flag = false;
  for (int i = 0; i < n; ++i)
  {
    if (!flag && map[x][i] == '.' && map[x][i + 1] == '.')
    {
      ++countN;
      flag = true;
    }
    if (flag && map[x][i] == 'X')
    {
      flag = false;
    }
  }
}

int main(int argc, char *argv[])
{
  countM = 0;
  countN = 0;

  cin >> n;

  for (int i = 1; i <= n; ++i)
  {
    cin >> s;
    for (int j = 1; j <= n; ++j)
    {
      map[i][j] = s[j - 1];
    }
  }

  for (int i = 1; i <= n; ++i)
  {
    checkM(i);
  }
  for (int i = 1; i <= n; ++i)
  {
    checkN(i);
  }

  cout << countN << " " << countM << endl;

  return 0;
}