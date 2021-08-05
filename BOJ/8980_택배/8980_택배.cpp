#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;

bool compare(const pair<pair<int, int>, int> &a, const pair<pair<int, int>, int> &b)
{
  if (a.first.second == b.first.second)
  {
    return a.first.first < b.first.first;
  }
  return a.first.second < b.first.second;
}

int main(int argc, char *argv[])
{
  int n, c;
  int m;
  int x, y, z;
  int get;
  int s, e;
  int capacity = 0;
  int result = 0;
  int truck[2001];
  vector<pair<pair<int, int>, int>> v; // 출발 도착 용량

  memset(truck, 0, sizeof(truck));

  cin >> n >> c;
  cin >> m;

  while (m--)
  {
    cin >> x >> y >> z;

    v.push_back({{x, y}, z});
  }

  sort(v.begin(), v.end(), compare);

  for (int i = 0; i < v.size(); ++i)
  {
    get = 0;
    s = v[i].first.first;
    e = v[i].first.second;
    capacity = v[i].second;

    for (int j = s; j < e; j++)
    {
      get = max(get, truck[j]);
    }

    get = min(c - get, capacity);
    result += get;

    for (int j = s; j < e; j++)
    {
      truck[j] += get;
    }
  }

  cout << result << endl;

  return 0;
}