#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int x = 2;

  cin >> n;

  while (n--)
  {
    x += (x - 1);
  }

  x *= x;

  cout << x << endl;

  return 0;
}