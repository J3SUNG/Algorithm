#include <iostream>
using namespace std;

int memo[40] = {
    0,
};

int main(int argc, char *argv[])
{
  int n;
  int result = 0;

  cin >> n;

  memo[0] = 1;
  memo[2] = 3;

  if (n % 2 == 1)
  {
    cout << "0" << endl;
    return 0;
  }

  for (int i = 4; i <= n; i += 2)
  {
    memo[i] = memo[i - 2] * 3;

    for (int j = 4; i - j >= 0; j += 2)
    {
      memo[i] += memo[i - j] * 2;
    }
  }

  cout << memo[n] << endl;
  return 0;
}