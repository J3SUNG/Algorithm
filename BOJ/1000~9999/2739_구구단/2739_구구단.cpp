#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  cin >> n;
  for (int i = 0; i < 9; i++)
  {
    cout << n << " * " << i + 1 << " = " << n * (i + 1) << "\n";
  }
  return 0;
}