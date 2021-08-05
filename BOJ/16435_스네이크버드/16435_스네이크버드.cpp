#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n, l;
  int f[10000];

  cin >> n >> l;

  for (int i = 0; i < n; ++i)
  {
    cin >> f[i];
  }

  sort(f, f + n);

  for (int i = 0; i < n; ++i)
  {
    if (l < f[i])
    {
      break;
    }
    ++l;
  }

  cout << l << endl;

  return 0;
}