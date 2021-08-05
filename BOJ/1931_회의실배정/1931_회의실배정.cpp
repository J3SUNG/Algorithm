#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

vector<pair<int, int>> v;

bool sortbysec(const pair<int, int> &a, const pair<int, int> &b)
{
  return (a.second < b.second);
}

int main(int argc, char *argv[])
{
  int n;
  long long time = 0;
  int endTime = 0;
  int count = 0;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    int x, y;
    cin >> x;
    cin >> y;

    v.push_back(make_pair(x, y));
  }

  sort(v.begin(), v.end());
  sort(v.begin(), v.end(), sortbysec);

  for (int i = 0; i < n; ++i)
  {
    if (v[i].first >= time)
    {
      ++count;
      time = v[i].second;
    }
  }

  cout << count << endl;

  return 0;
}