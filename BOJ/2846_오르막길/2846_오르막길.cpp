#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int sum = 0;
  int result = 0;
  int arr[1010];

  memset(arr, 0, sizeof(arr));

  cin >> n;

  cin >> arr[0];
  for (int i = 1; i < n; ++i)
  {
    cin >> arr[i];
    if (arr[i] > arr[i - 1])
    {
      sum += arr[i] - arr[i - 1];
    }
    else
    {
      result = max(result, sum);
      sum = 0;
    }
  }
  result = max(result, sum);

  cout << result << endl;

  return 0;
}