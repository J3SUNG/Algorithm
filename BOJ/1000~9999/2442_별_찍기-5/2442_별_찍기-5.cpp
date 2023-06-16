#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x;
  cin >> x;
  for (int i = 0; i < x; ++i)
  {
    for (int j = x - 1; j > 0 + i; --j)
    {
      cout << " ";
    }
    for (int k = 0; k < i * 2 + 1; ++k)
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