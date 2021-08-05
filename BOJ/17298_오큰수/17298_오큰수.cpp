#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  vector<int> v;
  stack<int> s;

  scanf("%d", &n);

  for (int i = 0; i < n; i++)
  {
    scanf("%d", &num);
    v.push_back(num);
  }

  vector<int> ans(v.size(), -1);

  for (int i = 0; i < v.size(); i++)
  {
    while (!s.empty() && v[s.top()] < v[i])
    {
      ans[s.top()] = v[i];
      s.pop();
    }
    s.push(i);
  }

  for (int x : ans)
  {
    cout << x << " ";
  }

  return 0;
}