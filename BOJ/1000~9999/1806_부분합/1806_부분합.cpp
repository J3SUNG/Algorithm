#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n, m;
  int i, j;
  int flag = 0;
  int num = 0;
  int count = 0;
  int minNum = 987654321;
  int arr[100010];

  memset(arr, 0, sizeof(arr));

  cin >> n;
  cin >> m;

  for (int i = 0; i < n; ++i)
  {
    cin >> arr[i];
  }

  for (i = 0, j = 0; i < n; ++i)
  {
    num += arr[i];
    ++count;

    while (num >= m)
    {
      minNum = min(minNum, count);
      num -= arr[j];
      ++j;
      --count;
      flag = 1;
    }
  }

  if (flag == 0)
  {
    cout << "0" << endl;
    return 0;
  }
  cout << minNum << endl;

  return 0;
}
