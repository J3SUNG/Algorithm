#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num = 1;

  cin >> n;

  int i = 0;

  while (1)
  {
    num = num + (6 * i);
    if (n <= num)
    {
      cout << i + 1 << endl;
      break;
    }
    ++i;
  }

  return 0;
}