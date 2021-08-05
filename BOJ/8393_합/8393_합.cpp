#include <iostream>
#include <stdlib.h>
using namespace std;

int main(int argc, char *argv[])
{
  int x = 0, value = 0;
  cin >> x;
  for (int i = 0; i <= x; ++i)
  {
    value += i;
  }
  cout << value << "\n";
  return 0;
}