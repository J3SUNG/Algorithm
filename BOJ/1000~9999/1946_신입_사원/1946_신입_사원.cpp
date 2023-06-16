#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
  int ts;
  int n;
  int num;
  int count;
  pair<int, int> p[100010];

  cin >> ts;

  while (ts--)
  {
    count = 1;

    cin >> n;

    for (int i = 0; i < n; ++i)
    {
      cin >> p[i].first >> p[i].second;
    }

    sort(p, p + n);

    num = p[0].second;

    for (int i = 1; i < n; ++i)
    {
      if (num > p[i].second)
      {
        num = p[i].second;
        ++count;
      }
    }

    cout << count << endl;
  }

  return 0;
}