#include <iostream>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int count = 0;

  cin >> n;

  for (int i = 1; i <= n; ++i)
  {
    if (i % 5 == 0)
    {
      ++count;
    }
    if (i % 25 == 0)
    {
      ++count;
    }
    if (i % 125 == 0)
    {
      ++count;
    }
  }

  cout << count << endl;

  return 0;
}