#include <iostream>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  int find;
  int arr[210];

  cin >> n;
  memset(arr, 0, sizeof(arr));

  for (int i = 0; i < n; ++i)
  {
    cin >> num;
    ++arr[num + 100];
  }

  cin >> find;

  cout << arr[find + 100] << endl;

  return 0;
}