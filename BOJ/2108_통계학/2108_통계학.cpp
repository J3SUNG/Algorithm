#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <math.h>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  double avg = 0;
  int sum = 0;
  int count = 0;
  int center;
  int centerN;
  int manyN;
  int arr[8010];
  int maxN = -987654321;
  int minN = 987654321;
  vector<int> v;

  cin >> n;

  memset(arr, 0, sizeof(arr));

  center = n / 2 + 1;
  for (int i = 0; i < n; ++i)
  {
    cin >> num;
    sum += num;
    maxN = max(maxN, num);
    minN = min(minN, num);
    ++arr[num + 4000];
    if (count < arr[num + 4000])
    {
      v.clear();
      count = arr[num + 4000];
      v.push_back(num + 4000);
    }
    else if (count == arr[num + 4000])
    {
      v.push_back(num + 4000);
    }
  }

  sort(v.begin(), v.end());

  avg = floor(((double)sum / n) + 0.5);
  sum = 0;
  for (int i = 0; i <= 8000; ++i)
  {
    sum += arr[i];
    if (sum >= center)
    {
      centerN = i - 4000;
      break;
    }
  }

  if (v.size() == 1)
  {
    manyN = v[0] - 4000;
  }
  else
  {
    manyN = v[1] - 4000;
  }

  printf("%.0lf\n", avg);
  printf("%d\n", centerN);
  printf("%d\n", manyN);
  printf("%d\n", maxN - minN);

  return 0;
}