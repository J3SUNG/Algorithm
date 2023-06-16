#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <string>
using namespace std;

bool compare(string a, string b)
{
  if (a.size() == b.size())
  {
    return a < b;
  }
  else
  {
    return a.size() < b.size();
  }
}

int main(int argc, char *argv[])
{
  int n;
  char s[100];
  vector<string> v;

  scanf("%d", &n);

  for (int i = 0; i < n; ++i)
  {
    scanf("%s", s);
    v.push_back(s);
  }

  sort(v.begin(), v.end(), compare);
  v.erase(unique(v.begin(), v.end()), v.end());

  for (int i = 0; i < v.size(); ++i)
  {
    cout << v[i] << endl;
  }

  return 0;
}