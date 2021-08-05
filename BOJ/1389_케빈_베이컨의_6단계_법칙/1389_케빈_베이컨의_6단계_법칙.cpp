#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

int people;
int relation;
int map[110][110];

int main(int argc, char *argv[])
{
  memset(map, 0, sizeof(map));

  int a, b;
  int sum = 0;
  int index = 0;
  int minPeople = 987654321;

  cin >> people;
  cin >> relation;

  for (int i = 0; i < relation; ++i)
  {
    cin >> a;
    cin >> b;

    map[a][b] = map[b][a] = 1;
  }

  for (int k = 1; k <= people; k++)
  {
    for (int i = 1; i <= people; i++)
    {
      for (int j = 1; j <= people; j++)
      {
        if (i == j)
        {
          continue;
        }
        else if (map[i][k] != 0 && map[k][j] != 0)
        {
          if (map[i][j] == 0)
          {
            map[i][j] = map[i][k] + map[k][j];
          }
          else
          {
            map[i][j] = min(map[i][j], map[i][k] + map[k][j]);
          }
        }
      }
    }
  }

  for (int i = 1; i <= people; ++i)
  {
    for (int j = 1; j <= people; ++j)
    {
      sum += map[i][j];
    }
    if (sum < minPeople)
    {
      minPeople = sum;
      index = i;
    }
    sum = 0;
  }

  cout << index << endl;

  return 0;
}