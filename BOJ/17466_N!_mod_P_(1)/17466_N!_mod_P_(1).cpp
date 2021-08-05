#include <iostream>
using namespace std;

long long fact(long long N, long long P)
{
  long long result = 1;

  for (long long i = 1; i <= N; i++)
  {
    result = result * i;
    result = result % P;
  }

  return result;
}

int main(int argc, char *argv[])
{
  long long N, P;

  cin >> N >> P;
  cout << fact(N, P) << endl;

  return 0;
}