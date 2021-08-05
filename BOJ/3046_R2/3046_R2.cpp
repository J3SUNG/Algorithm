#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n, avg;
  int result;

  cin >> n >> avg;

  result = (avg * 2) - n;

  cout << result << endl;

  return 0;
}