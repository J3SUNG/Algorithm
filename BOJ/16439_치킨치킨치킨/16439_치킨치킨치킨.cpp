#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int n, m;
int result = 0;
int arr[40][40];

void solve(int i, int c, int score[])
{
  int temp[40];

  for (int j = 0; j < n; ++j)
  {
    temp[j] = max(score[j], arr[j][i]);
  }

  if (c == 3)
  {
    int sum = 0;
    for (int j = 0; j < n; ++j)
    {
      sum += temp[j];
    }
    result = max(result, sum);
    return;
  }

  for (int j = i + 1; j < m; ++j)
  {
    solve(j, c + 1, temp);
  }

  return;
}

int main(int argc, char *argv[])
{
  int score[40];

  memset(score, 0, sizeof(score));
  memset(arr, 0, sizeof(arr));

  cin >> n >> m;

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < m; ++j)
    {
      cin >> arr[i][j];
    }
  }

  for (int i = 0; i < m; ++i)
  {
    solve(i, 1, score);
  }

  cout << result << endl;

  return 0;
}