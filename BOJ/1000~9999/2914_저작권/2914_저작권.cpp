#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <stack>
using namespace std;

int main(int argc, char *argv[])
{
  int n, m;

  cin >> n >> m;

  cout << n * (m - 1) + 1 << endl;

  return 0;
}