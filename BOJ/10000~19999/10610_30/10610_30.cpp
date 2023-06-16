#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  string N;

  cin >> N;

  long long sum = 0;
  bool zero = false;

  for (int i = 0; i < N.size(); i++)
  {
    sum += (N[i] - '0');
    if (!(N[i] - '0'))
    {
      zero = true;
    }
  }

  sort(N.begin(), N.end(), greater<int>());

  (sum % 3 || !zero) ? cout << -1 << "\n" : cout << N << "\n";

  return 0;
}