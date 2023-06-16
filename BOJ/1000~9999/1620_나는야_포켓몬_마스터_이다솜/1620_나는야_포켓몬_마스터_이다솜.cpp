#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <string>
using namespace std;

int n, m;
int result;
int low, high;
int mid;
string s;
vector<string> v1;
vector<pair<string, int>> v2;

int main(int argc, char *argv[])
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  cin >> n >> m;

  v1.push_back("");
  for (int i = 1; i <= n; ++i)
  {
    cin >> s;

    v1.push_back(s);
    v2.push_back({s, i});
  }

  sort(v2.begin(), v2.end());

  for (int i = 1; i <= m; ++i)
  {
    cin >> s;

    if (s[0] >= '0' && s[0] <= '9')
    {
      result = stoi(s);
      cout << v1[result] << "\n";
    }
    else
    {
      low = 0;
      high = n - 1;

      while (low <= high)
      {
        mid = (low + high) / 2;

        if (v2[mid].first == s)
        {
          cout << v2[mid].second << "\n";
          break;
        }
        else if (v2[mid].first < s)
        {
          low = mid + 1;
        }
        else
        {
          high = mid - 1;
        }
      }
    }
  }

  return 0;
}