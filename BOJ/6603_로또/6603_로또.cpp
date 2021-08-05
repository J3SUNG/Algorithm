#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int n;
int arr[20];
int com[20];

void DFS(int next, int depth)
{
  if (depth == 6)
  {
    for (int i = 0; i < 6; ++i)
    {
      cout << com[i] << ' ';
    }
    cout << '\n';
    return;
  }

  for (int i = next; i < n; ++i)
  {
    com[depth] = arr[i];
    DFS(i + 1, depth + 1);
  }
}

int main(int argc, char *argv[])
{
  while (1)
  {
    cin >> n;

    if (n == 0)
    {
      break;
    }

    for (int i = 0; i < n; ++i)
    {
      cin >> arr[i];
    }

    DFS(0, 0);
    cout << '\n';
  }

  return 0;
}