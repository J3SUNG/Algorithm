#include <iostream>
#include <algorithm>
using namespace std;
int main(int argc, char *argv[])
{
  int n;
  int value = 0;
  int arr[510][510];
  cin >> n;
  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j <= i; ++j)
    {
      cin >> arr[i][j];
    }
  }
  for (int i = 1; i < n; ++i)
  {
    for (int j = 0; j <= i; ++j)
    {
      if (j == 0)
      {
        arr[i][j] += arr[i - 1][j];
      }
      else if (j == i)
      {
        arr[i][j] += arr[i - 1][j - 1];
      }
      else
      {
        arr[i][j] += max(arr[i - 1][j], arr[i - 1][j - 1]);
      }
    }
  }
  for (int i = 0; i < n; ++i)
  {
    if (value < arr[n - 1][i])
    {
      value = arr[n - 1][i];
    }
  }
  cout << value;
  return 0;
}