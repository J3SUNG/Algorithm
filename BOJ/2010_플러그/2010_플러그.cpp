#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  int sum = 0;

  cin >> n;

  while (n--)
  {
    cin >> num;
    sum += num - 1;
  }
  ++sum;

  cout << sum << endl;

  return 0;
}