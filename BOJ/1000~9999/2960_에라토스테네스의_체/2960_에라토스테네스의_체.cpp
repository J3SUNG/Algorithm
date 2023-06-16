#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n, k;
  int arr[1010];

  memset(arr, 0, sizeof(arr));

  cin >> n >> k;

  for (int i = 2; i <= n; ++i)
  {
    for (int j = i; j <= n; j += i)
    {
      if (arr[j] == 0)
      {
        arr[j] = 1;
        --k;
      }
      if (k == 0)
      {
        cout << j << endl;
        return 0;
      }
    }
  }

  return 0;
}