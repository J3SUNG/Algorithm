#include <iostream>
using namespace std;

int N, S;
int arr[30];
int result = 0;

void solve(int index, int sum)
{
  sum += arr[index];

  if (index >= N)
  {
    return;
  }
  if (sum == S)
  {
    result++;
  }

  solve(index + 1, sum - arr[index]);
  solve(index + 1, sum);
}

int main(int argc, char *argv[])
{
  cin >> N >> S;

  for (int i = 0; i < N; i++)
  {
    cin >> arr[i];
  }

  solve(0, 0);

  cout << result << endl;
  return 0;
}