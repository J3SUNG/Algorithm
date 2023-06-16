#include <iostream>
using namespace std;

int A, B, C;

int power(int n, int k)
{
  if (k == 0)
  {
    return 1;
  }

  int temp = power(n, k / 2);
  int result = 1LL * temp * temp % C;

  if (k % 2)
  {
    result = 1LL * result * n % C;
  }

  return result;
}

int main(int argc, char *argv[])
{
  cin >> A;
  cin >> B;
  cin >> C;

  cout << power(A, B) << endl;
}