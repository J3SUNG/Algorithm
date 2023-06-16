#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n, r, c;
  int map[110][110];

  cin >> n >> r >> c;

  if ((r + c) % 2 == 0)
  {
    for (int i = 1; i <= n; ++i)
    {
      for (int j = 1; j <= n; ++j)
      {
        if ((i + j) % 2 == 0)
        {
          cout << "v";
        }
        else
        {
          cout << ".";
        }
      }
      cout << endl;
    }
  }
  else
  {
    for (int i = 1; i <= n; ++i)
    {
      for (int j = 1; j <= n; ++j)
      {
        if ((i + j) % 2 == 0)
        {
          cout << ".";
        }
        else
        {
          cout << "v";
        }
      }
      cout << endl;
    }
  }

  return 0;
}