#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
  int i;
  int n, l;
  int num;
  int count;
  int water[1001];

  cin >> n >> l;

  for (int i = 0; i < n; ++i)
  {
    cin >> water[i];
  }

  sort(water, water + n);

  i = 0;
  count = 0;

  while (1)
  {
    num = water[i];
    num = num + l - 1;
    ++i;
    ++count;

    while (1)
    {
      if (water[i] <= num && i < n)
      {
        ++i;
      }
      else
      {
        break;
      }
    }

    if (i >= n)
    {
      break;
    }
  }

  cout << count << endl;

  return 0;
}