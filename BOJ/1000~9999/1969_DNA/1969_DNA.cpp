#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
  int n, m;
  int index;
  int count = 0;
  int maxAlph;
  int maxIndex;
  int check[26];
  string s;
  string dna = "";
  vector<string> v;

  cin >> n >> m;

  for (int i = 0; i < n; ++i)
  {
    cin >> s;

    v.push_back(s);
  }

  for (int i = 0; i < m; ++i)
  {
    maxAlph = 0;

    memset(check, 0, sizeof(check));

    for (int j = 0; j < n; ++j)
    {
      index = v[j][i] - 'A';
      ++check[index];
    }
    for (int j = 0; j < 26; ++j)
    {
      if (maxAlph < check[j])
      {
        maxAlph = check[j];
        maxIndex = j;
      }
    }
    dna += 'A' + maxIndex;
  }

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < m; ++j)
    {
      if (v[i][j] != dna[j])
      {
        ++count;
      }
    }
  }

  cout << dna << endl;
  cout << count << endl;

  return 0;
}