#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  long long n;

  cin >> n;

  if (n % 7 == 0 || n % 7 == 2)
  {
    cout << "CY" << endl;
  }
  else
  {
    cout << "SK" << endl;
  }

  return 0;
}