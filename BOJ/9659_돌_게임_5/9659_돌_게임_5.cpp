#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  long long n;

  cin >> n;

  if (n % 2 == 1)
  {
    cout << "SK" << endl;
  }
  else
  {
    cout << "CY" << endl;
  }

  return 0;
}