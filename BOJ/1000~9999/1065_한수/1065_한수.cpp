#include <iostream>
using namespace std;

int check[3];

int func(int x)
{
  int count = 0;
  if (x < 100)
  {
    count = x;
  }
  else
  {
    count += 99;
    for (int j = 100; j <= x; ++j)
    {
      check[0] = j / 100;
      check[1] = (j % 100 / 10);
      check[2] = j % 10;
      if ((check[0] - check[1]) == (check[1] - check[2]))
      {
        ++count;
      }
      else if ((check[2] - check[1]) == (check[1] - check[0]))
      {
        ++count;
      }
    }
  }
  return count;
}

int main(int argc, char *argv[])
{
  int x;
  cin >> x;

  cout << func(x) << endl;

  return 0;
}