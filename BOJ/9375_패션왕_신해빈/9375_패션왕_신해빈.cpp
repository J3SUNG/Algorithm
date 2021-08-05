#include <iostream>
#include <cstring>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int ts;
  int n;
  int result;
  int flag;
  string s;
  vector<pair<string, int>> v;

  cin >> ts;

  while (ts--)
  {
    v.clear();
    flag = 0;
    result = 1;
    cin >> n;
    for (int i = 0; i < n; ++i)
    {
      cin >> s;
      cin >> s;
      pair<string, int> p;
      for (int i = 0; i < v.size(); ++i)
      {
        if (v[i].first == s)
        {
          ++v[i].second;
          flag = 1;
          break;
        }
      }
      if (flag == 0)
      {
        p.first = s;
        p.second = 1;
        v.push_back(p);
      }
      flag = 0;
    }
    for (int i = 0; i < v.size(); ++i)
    {
      result *= v[i].second + 1;
    }
    result -= 1;

    cout << result << endl;
  }

  return 0;
}