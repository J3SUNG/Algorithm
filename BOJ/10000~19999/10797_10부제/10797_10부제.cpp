#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int count = 0;
  int arr[5];

  cin >> n;

  for (int i = 0; i < 5; ++i)
  {
    cin >> arr[i];
    if (n == arr[i])
    {
      ++count;
    }
  }

  cout << count << endl;

  return 0;
}