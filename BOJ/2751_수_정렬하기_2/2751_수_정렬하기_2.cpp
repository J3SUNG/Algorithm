#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> v;

int main(int argc, char *argv[])
{
  int n;
  int num;
  int arr[1010];

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    scanf("%d", &num);
    v.push_back(num);
  }

  sort(v.begin(), v.end());

  for (int i = 0; i < v.size(); ++i)
  {
    printf("%d\n", v[i]);
  }

  return 0;
}