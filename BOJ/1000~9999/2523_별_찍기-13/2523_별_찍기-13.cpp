#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;

  cin >> n;

  for (int i = 1; i <= n * 2 - 1; ++i)
  {
    for (int j = 1; j <= n - abs(n - i); ++j)
    {
      cout << "*";
    }
    cout << "\n";
  }

  return 0;
}