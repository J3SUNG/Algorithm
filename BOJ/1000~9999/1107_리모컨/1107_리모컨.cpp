#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int n;
int minNum = 987654321;
string s;
int remote[10];

void solve(string x)
{
  for (int i = 0; i < 10; ++i)
  {
    if (!remote[i])
    {
      string y = x + to_string(i);
      minNum = min(minNum, abs(n - stoi(y)) + (int)y.length());

      if (y.length() < 6)
      {
        solve(y);
      }
    }
  }
}

int main(int argc, char *argv[])
{
  int m;

  cin >> n;
  cin >> m;

  memset(remote, 0, sizeof(remote));

  for (int i = 0; i < m; ++i)
  {
    int f;
    cin >> f;
    remote[f] = 1;
  }

  minNum = min(minNum, abs(100 - n));

  if (m != 10)
  {
    solve("");
  }

  cout << minNum << endl;
  return 0;
}