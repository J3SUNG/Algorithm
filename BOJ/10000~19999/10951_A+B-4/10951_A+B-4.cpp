#include <iostream>
#include <cstdio>
using namespace std;

int main(int argc, char *argv[])
{
  int x, y;

  while (scanf("%d %d", &x, &y) != EOF)
  {
    printf("%d\n", x + y);
  }
  return 0;
}