#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n, f;
  int i;

  cin >> n;
  cin >> f;

  n -= n % 100;

  for (i = 0; i < 100; ++i)
  {
    if ((n + i) % f == 0)
    {
      break;
    }
  }

  if (i < 10)
  {
    cout << 0 << i << endl;
  }
  else
  {
    cout << i << endl;
  }

  return 0;
}