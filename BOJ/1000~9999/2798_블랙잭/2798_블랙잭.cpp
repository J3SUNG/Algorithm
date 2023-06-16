#include <iostream>
#include <cstring>
using namespace std;

int n, m;
int minNum;
int nearNum;
int arr[110];

void DFS(int x, int c, int num)
{
  num += arr[x];

  if (m < num)
  {
    return;
  }

  if (c == 3)
  {
    if (minNum > m - num)
    {
      minNum = m - num;
      nearNum = num;
    }
    return;
  }

  for (int i = x + 1; i < n; ++i)
  {
    DFS(i, c + 1, num);
  }
}

int main(int argc, char *argv[])
{
  minNum = 987654321;
  nearNum = 987654321;
  cin >> n;
  cin >> m;

  memset(arr, 0, sizeof(arr));

  for (int i = 0; i < n; ++i)
  {
    cin >> arr[i];
  }

  for (int i = 0; i < n - 2; ++i)
  {
    DFS(i, 1, 0);
  }

  cout << nearNum << endl;

  return 0;
}