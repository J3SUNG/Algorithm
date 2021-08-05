#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int maxN = -987654321;
  int check = 0;
  int arr[9];

  for (int i = 1; i <= 9; ++i)
  {
    cin >> arr[i];
  }

  for (int i = 1; i <= 9; ++i)
  {
    if (maxN < arr[i])
    {
      maxN = arr[i];
      check = i;
    }
  }

  cout << maxN << endl;
  cout << check << endl;

  return 0;
}