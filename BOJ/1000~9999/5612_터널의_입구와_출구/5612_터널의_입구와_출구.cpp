#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n, m;
  int x, y, z;
  int result = 0;
  int arr[10010];

  memset(arr, 0, sizeof(arr));

  cin >> n >> m;

  z = m;

  for (int i = 1; i <= n; ++i)
  {
    cin >> x;
    cin >> y;

    z += x - y;

    if (z < 0)
    {
      cout << 0 << endl;
      return 0;
    }
    result = max(result, z);
  }

  cout << result << endl;

  return 0;
}