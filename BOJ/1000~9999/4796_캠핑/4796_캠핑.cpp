#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
  int a, b, c;
  int result;
  int i = 1;

  while (1)
  {
    result = 0;

    cin >> a >> b >> c;

    if (a == 0 && b == 0 && c == 0)
    {
      break;
    }

    result = (c / b) * a;
    result += c % b > a ? a : c % b;

    printf("Case %d: %d\n", i, result);

    ++i;
  }
  return 0;
}