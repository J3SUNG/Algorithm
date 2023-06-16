#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int h, m;

  cin >> h;
  cin >> m;

  if (m - 45 < 0)
  {
    m += 60;
    h -= 1;
  }
  if (h < 0)
  {
    h = 23;
  }
  m -= 45;

  cout << h << " " << m << endl;

  return 0;
}