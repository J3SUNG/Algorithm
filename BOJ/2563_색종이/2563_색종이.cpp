#include <iostream>
#include <cstring>
#include <queue>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int x, y;
  int count = 0;
  int map[110][110];

  cin >> n;

  memset(map, 0, sizeof(map));

  while (n--)
  {
    cin >> x >> y;

    for (int i = x; i < x + 10; ++i)
    {
      for (int j = y; j < y + 10; ++j)
      {
        map[i][j] = 1;
      }
    }
  }

  for (int i = 0; i <= 100; ++i)
  {
    for (int j = 0; j <= 100; ++j)
    {
      if (map[i][j] == 1)
      {
        ++count;
      }
    }
  }

  cout << count << endl;

  return 0;
}