#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int a[10000];
  int q = 0, w = 0, e = 0, r = 0;
  int result = 0;
  int i = 0;

  for (i = 0; i < 10000; ++i)
  {
    a[i] = i;
  }
  for (i = 0; i < 10000; ++i)
  {
    if (i / 1000 >= 1)
    {
      q = i / 1000;
    }
    if (i / 100 >= 1)
    {
      w = (i - q * 1000) / 100;
    }
    if (i / 10 >= 1)
    {
      e = (i - q * 1000 - w * 100) / 10;
    }
    r = i - q * 1000 - w * 100 - e * 10;
    result = i + q + w + e + r;
    if (result < 10000)
    {
      a[result] = NULL;
    }
  }
  for (i = 0; i < 10000; ++i)
  {
    if (a[i] != NULL)
    {
      cout << a[i] << endl;
    }
  }
  return 0;
}