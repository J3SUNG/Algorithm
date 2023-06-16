#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int n;

  cin >> n;

  int k = 1;
  int num = 0;

  while (1)
  {
    num += k;
    if (n <= num)
    {
      break;
    }
    ++k;
  }

  int a;
  int b;
  if (k % 2)
  {
    a = k + 1;
    b = 0;
    for (int i = 1; i <= n - num + k; ++i)
    {
      a -= 1;
      b += 1;
    }
  }
  else
  {
    a = 0;
    b = k + 1;
    for (int i = 1; i <= n - num + k; ++i)
    {
      a += 1;
      b -= 1;
    }
  }
  cout << a << "/" << b << endl;

  return 0;
}