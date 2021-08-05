#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int a, i, j;
  cin >> a;
  double b[a], max, result;
  for (i = 0; i < a; ++i)
  {
    cin >> b[i];

    if (max < b[i])
    {
      max = b[i];
    }
  }
  for (j = 0; j < a; ++j)
  {
    b[j] = b[j] / max * 100;
    result += b[j];
  }
  result = result / a;
  cout << result << endl;

  return 0;
}