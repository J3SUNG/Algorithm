#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int a, b;
  int count = 0;

  cin >> n;
  cin >> a >> b;

  while (a != b)
  {
    a = a / 2 + a % 2;
    b = b / 2 + b % 2;
    ++count;
  }

  cout << count << endl;

  return 0;
}