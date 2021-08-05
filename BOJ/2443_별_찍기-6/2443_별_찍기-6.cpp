#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x;
  cin >> x;
  for (int i = 0; i < x; ++i)
  {
    for (int j = x - i; j < x; ++j)
    {
      cout << " ";
    }
    for (int k = i; k < x * 2 - i - 1; ++k)
    {
      cout << "*";
    }
    if (i + 1 != x)
    {
      cout << endl;
    }
  }
  return 0;
}