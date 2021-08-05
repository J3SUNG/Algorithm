#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  double c1, c2;
  double count;
  double avg;
  double arr[10000];
  cin >> c1;
  cout << fixed;
  cout.precision(3);
  for (int i = 0; i < c1; ++i)
  {
    cin >> c2;
    count = 0;
    avg = 0;
    for (int j = 0; j < c2; ++j)
    {
      cin >> arr[j];
      avg += arr[j];
    }
    avg /= c2;
    for (int j = 0; j < c2; ++j)
    {
      if (arr[j] > avg)
      {
        count++;
      }
    }
    cout << 100.0 / c2 * count << "%\n";
  }
  return 0;
}