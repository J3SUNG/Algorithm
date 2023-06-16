#include <iostream>
using namespace std;

int house[14];

void init()
{
  for (int i = 0; i < 14; ++i)
  {
    house[i] = i + 1;
  }
}

int main(int argc, char *argv[])
{
  int cycle;
  int k, n;
  int result = 0;
  int tmp = 0;

  cin >> cycle;

  for (int i = 0; i < cycle; ++i)
  {
    cin >> k;
    cin >> n;
    init();
    for (int j = 0; j < k; ++j)
    {
      for (int h = 0; h < n; ++h)
      {
        house[h] += tmp;
        tmp = house[h];
      }
      result = tmp;
      tmp = 0;
    }
    cout << result << endl;
  }
  return 0;
}