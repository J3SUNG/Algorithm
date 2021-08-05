#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int num[110] = {
      0,
  };
  int n;
  int count = 0;
  cin >> n;

  for (int i = 1; i <= n; ++i)
  {
    cin >> num[i];
  }

  for (int j = n; j > 0; --j)
  {
    while (num[j] <= num[j - 1])
    {
      num[j - 1]--;
      count++;
    }
  }

  cout << count << endl;

  return 0;
}