#include <iostream>
#include <cstring>
#include <stack>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int E, S, M;
  int i = 1;

  cin >> E >> S >> M;

  while (1)
  {
    if ((i - E) % 15 == 0 && (i - S) % 28 == 0 && (i - M) % 19 == 0)
    {
      cout << i << endl;
      return 0;
    }
    ++i;
  }

  return 0;
}