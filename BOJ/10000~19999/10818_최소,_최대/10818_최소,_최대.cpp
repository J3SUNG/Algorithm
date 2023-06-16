#include <iostream>
#include <algorithm>
using namespace std;

int arr[1000010];

int main(int argc, char *argv[])
{
  int x;
  int maxN = -987654321;
  int minN = 987654321;
  cin >> x;

  for (int i = 0; i < x; ++i)
  {
    cin >> arr[i];
  }

  for (int i = 0; i < x; ++i)
  {
    maxN = max(maxN, arr[i]);
    minN = min(minN, arr[i]);
  }

  cout << minN << " " << maxN << endl;

  return 0;
}