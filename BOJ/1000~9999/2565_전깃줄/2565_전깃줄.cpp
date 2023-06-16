#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int maxNum = -987654321;
  vector<vector<int>> line;
  vector<int> arr;
  vector<int> DP;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    vector<int> v;
    int a, b;
    cin >> a >> b;
    v.push_back(a);
    v.push_back(b);
    line.push_back(v);
  }

  sort(line.begin(), line.end());

  for (int i = 0; i < n; ++i)
  {
    DP.push_back(1);
    arr.push_back(line[i][1]);
  }

  DP[0] = 1;
  for (int i = 1; i < n; ++i)
  {
    for (int j = i; j >= 0; --j)
    {
      if (arr[i] > arr[j] && DP[i] <= DP[j])
      {
        DP[i] = DP[j] + 1;
      }
    }
  }

  for (int i = 0; i < n; ++i)
  {
    maxNum = max(maxNum, DP[i]);
  }

  cout << DP.size() - maxNum << endl;

  return 0;
}