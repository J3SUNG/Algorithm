#include <iostream>
using namespace std;

unsigned long int memo[1000001] = {
    0,
};

int main(int argc, char *argv[])
{
  int num;

  memo[0] = 0;
  memo[1] = 0;
  memo[2] = 1;
  memo[3] = 2;
  cin >> num;
  for (int i = 4; i <= num; ++i)
  {
    memo[i] = ((i - 1) * (memo[i - 1] + memo[i - 2]) % 1000000000);
  }
  cout << memo[num];

  return 0;
}