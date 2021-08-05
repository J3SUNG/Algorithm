#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

int main(int argc, char *argv[])
{
  int x;

  cin >> x;

  if (x % 4 == 0 && (x % 400 == 0 || x % 100 != 0))
  {
    cout << "1" << endl;
  }
  else
  {
    cout << "0" << endl;
  }

  return 0;
}