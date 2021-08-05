#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int testcase;
  scanf("%d", &testcase);

  while (testcase--)
  {
    int x, y;
    long long i = 0;

    scanf("%d", &x);
    scanf("%d", &y);

    long long dist = y - x;

    while (++i)
    {
      i;
      if (dist <= i * i)
      {
        break;
      }
    }
    if (dist <= i * i - i)
    {
      printf("%d\n", i * 2 - 2);
    }
    else
    {
      printf("%d\n", i * 2 - 1);
    }
  }
  return 0;
}