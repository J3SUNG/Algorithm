#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int mul = 1;
  int num[3];
  int memo[10] = {
      0,
  };
  for (int i = 0; i < 3; ++i)
  {
    cin >> num[i];
    mul *= num[i];
  }
  while (mul > 0)
  {
    int index = mul % 10;
    memo[index]++;
    mul /= 10;
  }

  for (int i = 0; i < 10; ++i)
  {
    cout << memo[i] << endl;
  }

  return 0;
}