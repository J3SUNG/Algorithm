#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int GCD(int a, int b)
{
  if (a % b == 0)
  {
    return b;
  }

  return GCD(b, a % b);
}

int main(int argc, char *argv[])
{
  int n;
  int div;
  int arr[110];

  cin >> n;

  memset(arr, 0, sizeof(arr));

  for (int i = 0; i < n; ++i)
  {
    cin >> arr[i];
  }

  for (int i = 1; i < n; ++i)
  {
    div = GCD(arr[0], arr[i]);
    cout << arr[0] / div << "/" << arr[i] / div << endl;
  }

  return 0;
}