#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int minN = 987654321;
  int maxN = -987654321;
  int arr[60];

  cin >> n;

  memset(arr, 0, sizeof(arr));

  for (int i = 1; i <= n; ++i)
  {
    cin >> arr[i];
    minN = min(minN, arr[i]);
    maxN = max(maxN, arr[i]);
  }

  cout << minN * maxN << endl;

  return 0;
}