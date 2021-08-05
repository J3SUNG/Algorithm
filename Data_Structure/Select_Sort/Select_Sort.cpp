#include <algorithm>
#include <iostream>
using namespace std;

void selectSort(int array[], int n)
{
  int temp;

  for (int i = 0; i < n - 1; ++i)
  {
    int index = i;
    for (int j = i + 1; j < n; ++j)
    {
      if (array[j] < array[index])
        index = j;
    }
    temp = array[i];
    array[i] = array[index];
    array[index] = temp;
  }
}

int main(int argc, char *argv[])
{
  int length = 5;
  int array[length] = {30, 50, 20, 10, 40};

  selectSort(array, length);

  for (int i = 0; i < length; ++i)
    cout << array[i] << ' ';
  return 0;
}