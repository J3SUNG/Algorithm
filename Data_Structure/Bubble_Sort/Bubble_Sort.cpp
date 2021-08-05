#include <iostream>
using namespace std;

void buubleSort(int array[], int len)
{
  int temp;

  for (int i = len - 1; i > 0; --i)
  {
    for (int j = 0; j < i; ++j)
    {
      if (array[j] > array[j + 1])
      {
        temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
      }
    }
  }
}

int main(int argc, char *argv[])
{
  const int n = 10;
  int array[n] = {2, 6, 4, 8, 10, 12, 89, 68, 45, 37};

  buubleSort(array, n);

  for (int i = 0; i < n; ++i)
  {
    cout << array[i] << " ";
  }

  return 0;
}