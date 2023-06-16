#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  int cute = 0;
  int notCute = 0;

  cin >> n;

  while (n--)
  {
    cin >> num;

    if (num == 1)
    {
      ++cute;
    }
    else
    {
      ++notCute;
    }
  }

  if (cute < notCute)
  {
    cout << "Junhee is not cute!" << endl;
  }
  else
  {
    cout << "Junhee is cute!" << endl;
  }

  return 0;
}