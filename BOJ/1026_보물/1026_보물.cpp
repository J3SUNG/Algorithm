#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  vector<int> A;
  vector<int> B;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    int x;
    cin >> x;

    A.push_back(x);
  }

  for (int i = 0; i < n; ++i)
  {
    int x;
    cin >> x;

    B.push_back(x);
  }

  sort(A.begin(), A.end());
  sort(B.begin(), B.end(), greater<int>());

  num = 0;
  for (int i = 0; i < n; ++i)
  {
    num += A[i] * B[i];
  }

  cout << num << endl;

  return 0;
}