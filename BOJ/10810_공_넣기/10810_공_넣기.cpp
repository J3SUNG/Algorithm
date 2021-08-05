#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n, m;
  int a, b, c;
  int count;
  int map[110];

  memset(map, 0, sizeof(map));

  cin >> n >> m;

  while (m--)
  {
    cin >> a >> b >> c;

    for (int i = a; i <= b; ++i)
    {
      map[i] = c;
    }
  }

  for (int i = 1; i <= n; ++i)
  {
    count = 0;
    cout << map[i] << " ";
  }
  cout << endl;

  return 0;
}