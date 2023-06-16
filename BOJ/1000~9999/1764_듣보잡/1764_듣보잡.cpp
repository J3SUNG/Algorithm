#include <iostream>
#include <string>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n, m;
  string s;
  vector<string> v1;
  vector<string> v2;

  cin >> n >> m;

  v1.resize(n);
  for (int i = 0; i < n; ++i)
  {
    cin >> v1[i];
  }

  sort(v1.begin(), v1.end());

  for (int i = 0; i < m; ++i)
  {
    cin >> s;

    if (binary_search(v1.begin(), v1.end(), s))
    {
      v2.push_back(s);
    }
  }

  sort(v2.begin(), v2.end());

  cout << v2.size() << endl;
  for (int i = 0; i < v2.size(); ++i)
  {
    cout << v2[i] << endl;
  }

  return 0;
}