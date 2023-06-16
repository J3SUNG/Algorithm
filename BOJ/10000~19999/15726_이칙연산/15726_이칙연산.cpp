#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  double x, y, z;
  double num1, num2;

  cin >> x;
  cin >> y;
  cin >> z;

  num1 = x * y / z;
  num2 = x / y * z;

  cout << (long long)max(num1, num2) << endl;

  return 0;
}