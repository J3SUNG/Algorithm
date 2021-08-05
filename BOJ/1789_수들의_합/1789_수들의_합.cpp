#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  long long n;
  long long sum = 0;
  long long count = 1;

  cin >> n;

  while (1)
  {
    sum += count;
    if (sum > n)
    {
      --count;
      break;
    }
    ++count;
  }

  cout << count << endl;

  return 0;
}