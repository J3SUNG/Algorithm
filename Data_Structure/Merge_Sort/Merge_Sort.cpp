#include <iostream>
using namespace std;

int arr[10] = {5, 4, 3, 2, 1, 457, 5412, 879456, 45120, 6523};

void mergeSort(int list[], int start, int mid, int end)
{
  int i, j, k;
  int temp[11];

  i = start;
  j = mid + 1;
  k = start;

  while (i <= mid && j <= end)
  {
    if (list[i] <= list[j])
    {
      temp[k++] = list[i++];
    }
    else
    {
      temp[k++] = list[j++];
    }
  }

  if (i > mid)
  {
    for (int l = j; l <= end; l++)
    {
      temp[k++] = list[l];
    }
  }
  else
  {
    for (int l = i; l <= mid; l++)
    {
      temp[k++] = list[l];
    }
  }

  for (int l = start; l <= end; l++)
  {
    list[l] = temp[l];
  }
}

void merge(int list[], int start, int end)
{
  int mid;
  if (start < end)
  {
    mid = (start + end) / 2;
    merge(list, start, mid);
    merge(list, mid + 1, end);
    mergeSort(list, start, mid, end);
  }
}

int main(int argc, char *argv[])
{
  merge(arr, 0, 9);

  for (int i = 0; i < 10; ++i)
  {
    cout << arr[i] << " ";
  }

  return 0;
}