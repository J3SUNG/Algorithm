#include <iostream>
#include <string>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  priority_queue<int, vector<int>, greater<int>> pqMax;
  priority_queue<int> pqMin;

  scanf("%d", &n);

  while (n--)
  {
    scanf("%d", &num);

    if (pqMin.empty() || pqMin.top() >= num)
    {
      pqMin.push(num);
      if (pqMin.size() > pqMax.size() + 1)
      {
        pqMax.push(pqMin.top());
        pqMin.pop();
      }
    }
    else if (pqMax.empty() || pqMax.top() <= num)
    {
      pqMax.push(num);
      if (pqMax.size() > pqMin.size())
      {
        pqMin.push(pqMax.top());
        pqMax.pop();
      }
    }
    else if (pqMin.size() <= pqMax.size())
    {
      pqMin.push(num);
    }
    else if (pqMin.size() > pqMax.size())
    {
      pqMax.push(num);
    }

    printf("%d\n", pqMin.top());
  }

  return 0;
}