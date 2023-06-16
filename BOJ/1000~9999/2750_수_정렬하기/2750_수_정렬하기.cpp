#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  int arr[1010];
  vector<int> v;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> num;
    v.push_back(num);
  }

  sort(v.begin(), v.end());

  for (int i = 0; i < v.size(); ++i)
  {
    cout << v[i] << endl;
  }

  return 0;
}