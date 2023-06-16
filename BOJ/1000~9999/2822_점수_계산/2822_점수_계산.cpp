#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int num;
  int sum = 0;
  vector<pair<int, int>> v;
  vector<int> index;

  for (int i = 1; i <= 8; ++i)
  {
    cin >> num;
    v.push_back(make_pair(num, i));
  }

  sort(v.begin(), v.end(), greater<pair<int, int>>());

  for (int i = 0; i < 5; ++i)
  {
    sum += v[i].first;
    index.push_back(v[i].second);
  }
  cout << sum << endl;

  sort(index.begin(), index.end());

  for (int i = 0; i < 5; ++i)
  {
    cout << index[i] << " ";
  }
  cout << endl;

  return 0;
}