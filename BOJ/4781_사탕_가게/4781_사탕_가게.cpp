#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

int n, c;
int DP[10010];
double m, p;
int mm, pp;
vector<pair<int, int>> v;

bool compare(const pair<int, int> &a, const pair<int, int> &b)
{
  if (a.second == b.second)
  {
    return a.first > b.first;
  }
  return a.second < b.second;
}

int main(int argc, char *argv[])
{
  while (1)
  {
    cin >> n >> m;

    mm = (int)(m * 100 + 0.5);

    v.clear();
    memset(DP, 0, sizeof(DP));

    if (n == 0 && mm == 0)
    {
      break;
    }

    for (int i = 0; i < n; ++i)
    {
      cin >> c >> p;

      pp = (int)(p * 100 + 0.5);

      v.push_back({c, pp});
    }

    sort(v.begin(), v.end(), compare);

    for (int i = 0; i < v.size(); ++i)
    {
      DP[0] = 0;
      for (int j = 0; j <= mm; ++j)
      {
        if (j + v[i].second > mm)
        {
          break;
        }

        DP[j + v[i].second] = max(DP[j + v[i].second], DP[j] + v[i].first);
      }
    }

    cout << max(DP[mm], 0) << endl;
  }

  return 0;
}