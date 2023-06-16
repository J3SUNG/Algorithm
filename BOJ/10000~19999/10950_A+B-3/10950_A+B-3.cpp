#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int x, y;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> x;
    cin >> y;

    cout << x + y << endl;
  }

  return 0;
}