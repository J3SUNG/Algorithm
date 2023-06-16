#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
  int n, k;
  int num;
  int s, e;
  int result = 0;
  vector<int> v;
  vector<int> temp;
  priority_queue<pair<int, int>> pq;

  cin >> n >> k;

  for (int i = 0; i < n; ++i)
  {
    cin >> num;
    v.push_back(num);
  }

  sort(v.begin(), v.end());

  for (int i = 1; i < n; ++i)
  {
    pq.push({-(v[i] - v[i - 1]), i});
  }

  while (pq.size() >= k)
  {
    pq.pop();
  }

  while (!pq.empty())
  {
    temp.push_back(-(pq.top().second));
    pq.pop();
  }

  sort(temp.begin(), temp.end());
  temp.push_back(-(n));

  s = 0;
  for (int i = 0; i < temp.size(); ++i)
  {
    e = -temp[i] - 1;
    result += v[e] - v[s];
    s = -temp[i];
  }

  cout << result << endl;

  return 0;
}