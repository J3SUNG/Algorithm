#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x, y, z[10000], t[10000], c = 0;
  cin >> x;
  cin >> y;
  for (int i = 0; i < 10000; i++)
  {
    t[i] = -1;
  }
  for (int i = 0; i < x; i++)
  {
    cin >> z[i];
    if (z[i] < y)
    {
      t[c++] = z[i];
    }
  }
  c = 0;
  while (t[c] != -1)
  {
    cout << t[c++] << " ";
  }
  return 0;
}