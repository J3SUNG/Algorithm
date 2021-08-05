#include <iostream>
#include <algorithm>
using namespace std;

int map[100010][3];
int minDP[3];
int maxDP[3];

void init()
{
  for (int i = 0; i < 100010; ++i)
  {
    for (int j = 0; j < 3; ++j)
    {
      map[i][j] = 0;
    }
  }
}

int main(int argc, char *argv[])
{
  int x, y, z;
  int n;
  cin >> n;

  for (int i = 1; i <= n; ++i)
  {
    cin >> map[i][0];
    cin >> map[i][1];
    cin >> map[i][2];
  }

  maxDP[0] = map[1][0];
  maxDP[1] = map[1][1];
  maxDP[2] = map[1][2];

  minDP[0] = map[1][0];
  minDP[1] = map[1][1];
  minDP[2] = map[1][2];

  for (int i = 2; i <= n; ++i)
  {
    x = maxDP[0];
    y = maxDP[1];
    z = maxDP[2];

    maxDP[0] = max(x, y) + map[i][0];
    maxDP[1] = max({x, y, z}) + map[i][1];
    maxDP[2] = max(y, z) + map[i][2];

    x = minDP[0];
    y = minDP[1];
    z = minDP[2];

    minDP[0] = min(x, y) + map[i][0];
    minDP[1] = min({x, y, z}) + map[i][1];
    minDP[2] = min(y, z) + map[i][2];
  }

  cout << max({maxDP[0], maxDP[1], maxDP[2]}) << " " << min({minDP[0], minDP[1], minDP[2]}) << endl;

  return 0;
}