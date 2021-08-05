#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  vector<int> v;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    int x;
    cin >> x;
    v.push_back(x);
  }

  sort(v.begin(), v.end());

  for (int i = 0; i < n; ++i)
  {
    cout << v[i] << " ";
  }

  return 0;
}