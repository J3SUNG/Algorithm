#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

int main(int argc, char *argv[])
{
  int arr[50] = {
      0,
  };
  int x;
  int count = 0;

  for (int i = 0; i < 10; ++i)
  {
    cin >> x;
    arr[x % 42] = 1;
  }

  for (int i = 0; i < 42; ++i)
  {
    if (arr[i] == 1)
    {
      ++count;
    }
  }

  cout << count << endl;

  return 0;
}