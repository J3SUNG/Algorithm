#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int x;
  long long int f = 1;

  cin >> x;

  for (int i = 1; i <= x; ++i)
  {
    f *= i;
  }

  cout << f << endl;

  return 0;
}