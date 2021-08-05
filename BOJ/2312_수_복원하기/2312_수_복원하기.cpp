#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int temp;
  int ts;
  int arr[100010];

  cin >> ts;

  while (ts--)
  {
    memset(arr, 0, sizeof(arr));

    cin >> n;

    temp = n;

    for (int i = 2; i <= temp; ++i)
    {
      while (temp % i == 0)
      {
        temp /= i;
        ++arr[i];
      }
    }

    for (int i = 2; i <= n; ++i)
    {
      if (arr[i])
      {
        cout << i << " " << arr[i] << endl;
      }
    }
  }

  return 0;
}