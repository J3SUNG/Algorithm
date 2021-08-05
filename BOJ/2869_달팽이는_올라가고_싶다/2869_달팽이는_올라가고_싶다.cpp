#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int a, b, v;
  int num = 0;

  cin >> a >> b >> v;

  num = (v - b - 1) / (a - b) + 1;

  cout << num << endl;

  return 0;
}