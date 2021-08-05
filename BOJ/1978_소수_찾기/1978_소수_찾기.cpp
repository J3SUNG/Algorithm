#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num[100];
  int count = 0;
  cin >> n;
  for (int i = 0; i < n; ++i)
  {
    cin >> num[i];
    if (num[i] == 1)
    {
      count++;
      continue;
    }
    for (int j = 2; j < num[i] - 1; ++j)
    {
      if (num[i] % j == 0)
      {
        count++;
        break;
      }
    }
  }
  cout << n - count;
  return 0;
}