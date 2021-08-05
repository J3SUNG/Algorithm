#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int solve(int N, int M)
{
  if (N <= 0 || M <= 0)
  {
    return 0;
  }

  return min(N / 2, M);
}

int main(int argc, char *argv[])
{
  int N, M, K;
  int result = 0;

  cin >> N >> M >> K;

  for (int i = 0; i < K / 2 + 1; ++i)
  {
    result = max(result, solve(N - K + i, M - i));
    result = max(result, solve(N - i, M - K + i));
  }

  cout << result << endl;

  return 0;
}