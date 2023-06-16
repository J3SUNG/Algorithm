#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  long long int a, b, c;
  int x;

  cin >> a;
  cin >> b;
  cin >> c;

  if (b >= c)
  {
    cout << "-1" << endl;
    return 0;
  }

  x = a / (c - b);
  cout << x + 1 << endl;

  return 0;
}