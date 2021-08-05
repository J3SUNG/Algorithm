#include <iostream>
#include <cstring>
#include <stack>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int num;
  int sum = 0;
  stack<int> s;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> num;
    if (num == 0)
    {
      s.pop();
    }
    else
    {
      s.push(num);
    }
  }

  for (int i = 0; !s.empty(); ++i)
  {
    sum += s.top();
    s.pop();
  }

  cout << sum << endl;

  return 0;
}