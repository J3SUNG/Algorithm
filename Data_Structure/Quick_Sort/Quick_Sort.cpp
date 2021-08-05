#include <iostream>
using namespace std;

int array[10000001];

void quickSort(int i, int j)
{
  if (i >= j)
  {
    return;
  }

  int pivot = array[(i + j) / 2];
  int left = i;
  int right = j;

  while (left <= right)
  {
    while (array[left] < pivot)
    {
      ++left;
    }
    while (array[right] > pivot)
    {
      --right;
    }
    if (left <= right)
    {
      swap(array[left], array[right]);
      ++left;
      --right;
    }
  }

  quickSort(i, right);
  quickSort(left, j);
}

int main()
{
  int n;
  int num;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> num;
    array[i] = num;
  }

  quickSort(0, n - 1);

  for (int i = 0; i < n; i++)
  {
    cout << array[i] << " ";
  }
}
