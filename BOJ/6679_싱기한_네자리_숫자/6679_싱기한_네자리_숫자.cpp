#include <iostream>

const int MAX = 9999;
const int MIN = 1000;
using namespace std;

int main(int argc, char const *argv[])
{
  int ten, twe, hex;
  for (int i = MIN; i <= MAX; i++)
  {
    ten = 0;
    twe = 0;
    hex = 0;

    for (int n = i; n > 0; n /= 10)
    {
      ten += n % 10;
    }

    for (int n = i; n > 0; n /= 12)
    {
      twe += n % 12;
    }

    // 16진수 각 자리수의 합
    for (int n = i; n > 0; n /= 16)
    {
      hex += n % 16;
    }

    if (ten == twe && twe == hex)
    {
      cout << i << "\n";
    }
  }

  return 0;
}