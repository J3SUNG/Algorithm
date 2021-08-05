#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
  int n, t;
  int temp;
  queue<int> q;

  cin >> n >> t;

  for (int i = 1; i <= n; ++i)
  {
    q.push(i);
  }

  cout << "<";
  while (1)
  {
    for (int i = 0; i < t - 1; ++i)
    {
      temp = q.front();
      q.pop();
      q.push(temp);
    }
    cout << q.front();
    q.pop();
    if (!q.size())
    {
      break;
    }
    cout << ", ";
  }
  cout << ">";

  return 0;
}