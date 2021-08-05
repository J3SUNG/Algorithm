#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x;
  cin >> x;

  for (int i = 1; i <= x; ++i)
  {
    for (int j = x - i; j < x; ++j)
    {
      cout << "*";
    }
    for (int j = 0; j < x * 2 - (2 * i); ++j)
    {
      cout << " ";
    }
    for (int j = x - i; j < x; ++j)
    {
      cout << "*";
    }
    cout << endl;
  }
  for (int i = x - 1; i > 0; --i)
  {
    for (int j = x - i; j < x; ++j)
    {
      cout << "*";
    }
    for (int j = 0; j < x * 2 - (2 * i); ++j)
    {
      cout << " ";
    }
    for (int j = x - i; j < x; ++j)
    {
      cout << "*";
    }
    cout << endl;
  }

  return 0;
}