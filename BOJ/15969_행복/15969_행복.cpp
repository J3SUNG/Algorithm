#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int arr[1010];
  int minNum = 987654321;
  int maxNum = -987654321;
  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> arr[i];
    minNum = min(minNum, arr[i]);
    maxNum = max(maxNum, arr[i]);
  }

  cout << maxNum - minNum << endl;

  return 0;
}