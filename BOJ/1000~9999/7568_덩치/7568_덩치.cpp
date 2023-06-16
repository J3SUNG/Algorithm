#include <iostream>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int people[60][3];

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> people[i][0];
    cin >> people[i][1];
    people[i][2] = 1;
  }

  for (int i = 0; i < n; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (i == j)
      {
        continue;
      }

      int w1, w2, h1, h2;
      w1 = people[i][0];
      w2 = people[j][0];
      h1 = people[i][1];
      h2 = people[j][1];

      if (w1 < w2 && h1 < h2)
      {
        ++people[i][2];
      }
    }
    cout << people[i][2] << " ";
  }
  cout << endl;

  return 0;
}