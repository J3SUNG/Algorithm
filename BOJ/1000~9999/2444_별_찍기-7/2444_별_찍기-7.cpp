#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x;
  cin >> x;

  for (int i = 0; i < x; ++i)
  {
    for (int k = x - i - 1; k > 0; --k)
    {
      cout << " ";
    }
    for (int j = x + i * 2; j >= x; --j)
    {
      cout << "*";
    }
    cout << endl;
  }
  for (int i = 1; i < x; ++i)
  {
    for (int k = x - i; k < x; ++k)
    {
      cout << " ";
    }
    for (int j = -x + i * 2 + 1; j < x; ++j)
    {
      cout << "*";
    }
    cout << endl;
  }

  return 0;
}