#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int num = 0;
  int sum = 0;
  for (int i = 0; i < 5; ++i)
  {
    cin >> num;

    if (num < 40)
    {
      num = 40;
    }

    sum += num;
  }

  cout << sum / 5 << endl;

  return 0;
}