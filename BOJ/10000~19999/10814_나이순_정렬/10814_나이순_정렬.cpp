#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <string>
#define fio ios_base::sync_with_stdio(0), cin.tie(0)
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num = 0;
  char s[110];
  vector<string> v[210];

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> num;
    cin >> s;

    v[num].push_back(s);
  }

  for (int i = 0; i < 210; ++i)
  {
    for (int j = 0; j < v[i].size(); ++j)
    {
      cout << i << " " << v[i][j] << "\n";
    }
  }

  return 0;
}