#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  int sum;

  sum = 5;
  num = 7;

  cin >> n;

  for (int i = 2; i <= n; ++i)
  {
    sum += num;
    num += 3;

    sum %= 45678;
    num %= 45678;
  }

  cout << sum << endl;

  return 0;
}