#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
  int ts;
  int n, m;
  int c;
  int num;
  int here;

  scanf("%d", &ts);

  while (ts--)
  {
    c = 0;

    queue<pair<int, int>> q;
    priority_queue<int> pq;

    scanf("%d%d", &n, &m);

    for (int i = 0; i < n; i++)
    {
      scanf("%d", &num);

      q.push({num, i});
      pq.push(num);
    }

    while (q.size())
    {
      here = q.front().first;
      num = q.front().second;
      q.pop();

      if (pq.top() == here)
      {
        ++c;
        pq.pop();
        if (num == m)
        {
          break;
        }
      }
      else
        q.push({here, num});
    }
    printf("%d\n", c);
  }
  return 0;
}