#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int num;
  int result = 0;

  for (int i = 0; i < 5; ++i)
  {
    cin >> num;
    result += num * num;
  }

  result = result % 10;

  cout << result << endl;

  return 0;
}