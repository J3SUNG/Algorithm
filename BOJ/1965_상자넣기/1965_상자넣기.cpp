#include <iostream>
using namespace std;

int arr[1000];
int memo[1000];

void init(int x)
{
  for (int i = 0; i < x; ++i)
  {
    arr[i] = 0;
    memo[i] = 1;
  }
}

int main(int argc, char *argv[])
{
  int x;
  int result = 0;
  cin >> x;
  init(x);
  for (int i = 0; i < x; ++i)
  {
    cin >> arr[i];
  }
  memo[x - 1] = 1;
  for (int i = x - 1; i >= 0; --i)
  {
    for (int j = i + 1; j < x; ++j)
    {
      if (arr[i] < arr[j] && memo[i] <= memo[j])
      {
        memo[i] = memo[j] + 1;
      }
    }
  }
  for (int i = 0; i < x; ++i)
  {
    if (result < memo[i])
    {
      result = memo[i];
    }
  }
  cout << result;
  return 0;
}