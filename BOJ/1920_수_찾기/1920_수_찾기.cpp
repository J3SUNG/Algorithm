#include <iostream>
#include <string>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int arr[100010];
  int num;
  int n, m;

  scanf("%d", &n);

  for (int i = 0; i < n; ++i)
  {
    scanf("%d", &arr[i]);
  }

  sort(arr, arr + n);

  scanf("%d", &m);
  for (int i = 0; i < m; ++i)
  {
    scanf("%d", &num);

    if (binary_search(arr, arr + n, num))
    {
      printf("1\n");
    }
    else
    {
      printf("0\n");
    }
  }

  return 0;
}