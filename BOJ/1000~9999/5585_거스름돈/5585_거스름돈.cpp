#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int count = 0;

  cin >> n;

  n = 1000 - n;

  while (1)
  {
    if (n == 0)
    {
      break;
    }
    if (n >= 500)
    {
      n -= 500;
      ++count;
      continue;
    }
    if (n >= 100)
    {
      n -= 100;
      ++count;
      continue;
    }
    if (n >= 50)
    {
      n -= 50;
      ++count;
      continue;
    }
    if (n >= 10)
    {
      n -= 10;
      ++count;
      continue;
    }
    if (n >= 5)
    {
      n -= 5;
      ++count;
      continue;
    }
    if (n >= 1)
    {
      n -= 1;
      ++count;
      continue;
    }
  }

  cout << count << endl;

  return 0;
}