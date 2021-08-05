#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int arr[5][3];
  int maxPeople = -1;

  memset(arr, 0, sizeof(arr));

  for (int i = 1; i <= 4; ++i)
  {
    cin >> arr[i][0];
    cin >> arr[i][1];
    arr[i][2] = arr[i][1] - arr[i][0] + arr[i - 1][2];
    maxPeople = max(maxPeople, arr[i][2]);
  }

  cout << maxPeople << endl;

  return 0;
}