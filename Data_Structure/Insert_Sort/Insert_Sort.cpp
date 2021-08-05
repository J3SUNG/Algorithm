#include <iostream>
#define MAX_SIZE 5

using namespace std;

void insertionSort(int list[], int n)
{
  int i, j, temp;

  for (i = 1; i < n; ++i)
  {
    temp = list[i];

    for (j = i - 1; j >= 0 && list[j] > temp; --j)
    {
      list[j + 1] = list[j];
    }

    list[j + 1] = temp;
  }
}

int main(int argc, char *argv[])
{
  int i;
  int n = MAX_SIZE;
  int list[n] = {8, 5, 6, 2, 4};

  insertionSort(list, n);

  for (i = 0; i < n; i++)
  {
    cout << list[i] << " ";
  }
}
