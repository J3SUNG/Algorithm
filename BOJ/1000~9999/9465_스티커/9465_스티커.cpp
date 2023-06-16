#include <iostream>
#include <algorithm>
using namespace std;

int memo[2][100010];
int arr[2][100010];

void init()
{
  for (int i = 0; i < 2; ++i)
  {
    for (int j = 0; j < 100010; ++j)
    {
      arr[i][j] = 0;
      memo[i][j] = 0;
    }
  }
}

int main(int argc, char *argv[])
{

  int cycle;
  cin >> cycle;
  for (int i = 0; i < cycle; ++i)
  {
    int n;
    cin >> n;
    init();
    for (int j = 0; j < 2; ++j)
    {
      for (int k = 0; k < n; ++k)
      {
        cin >> arr[j][k];
        memo[j][k] = arr[j][k];
      }
    }
    memo[0][1] = memo[1][0] + arr[0][1];
    memo[1][1] = memo[0][0] + arr[1][1];
    for (int k = 2; k < n; ++k)
    {
      for (int j = 0; j < 2; ++j)
      {
        if (j == 1)
        {
          memo[j][k] += max(memo[0][k - 1], memo[0][k - 2]);
        }
        else
        {
          memo[j][k] += max(memo[1][k - 1], memo[1][k - 2]);
        }
      }
    }
    int maxNum = -987654321;

    maxNum = max(memo[1][n - 1], memo[0][n - 1]);
    cout << maxNum << endl;
  }

  return 0;
}