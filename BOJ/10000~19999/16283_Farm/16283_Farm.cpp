#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int a, b;
int n, w;
int result[2];
int c = 0;

void solve(int x, int y)
{
  int num;
  num = a * x;
  num += b * y;

  if (num == w)
  {
    result[0] = x;
    result[1] = y;
    ++c;
  }
}

int main(int argc, char *argv[])
{
  cin >> a >> b;
  cin >> n >> w;

  for (int i = 1; i < n; ++i)
  {
    if (c > 2)
    {
      break;
    }
    solve(i, n - i);
  }

  if (c == 1)
  {
    cout << result[0] << " " << result[1] << endl;
  }
  else
  {
    cout << "-1" << endl;
  }

  return 0;
}