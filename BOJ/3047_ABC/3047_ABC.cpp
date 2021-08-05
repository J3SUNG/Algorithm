#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int num;
  string s;
  vector<int> v;

  for (int i = 0; i < 3; ++i)
  {
    cin >> num;
    v.push_back(num);
  }

  sort(v.begin(), v.end());

  cin >> s;

  for (int i = 0; i < 3; ++i)
  {
    if (s[i] == 'A')
    {
      cout << v[0] << " ";
    }
    else if (s[i] == 'B')
    {
      cout << v[1] << " ";
    }
    else if (s[i] == 'C')
    {
      cout << v[2] << " ";
    }
  }
  cout << endl;

  return 0;
}