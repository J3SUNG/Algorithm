#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int arr[10] = {
      0,
  };
  int num;
  int index;
  int max = 0;

  cin >> num;

  do
  {
    index = num % 10;
    num /= 10;
    arr[index]++;
  } while (num != 0);

  arr[6] += arr[9];
  arr[6]++;
  arr[6] /= 2;
  arr[9] = 0;

  for (int i = 0; i < 10; ++i)
  {
    if (arr[i] > max)
    {
      max = arr[i];
    }
  }

  cout << max << endl;

  return 0;
}