#include <iostream>
#include <cstring>
#include <stack>
#include <vector>
#include <algorithm>
using namespace std;

int n;
int arr[100010];
stack<int> s;
vector<char> v;
int num;

int main(int argc, char *argv[])
{
  num = 1;

  scanf("%d", &n);

  for (int i = 0; i < n; ++i)
  {
    scanf(" %d", &arr[i]);
  }

  for (int i = 0; i < n; ++i)
  {
    if (s.empty() || s.top() != arr[i])
    {
      while (1)
      {
        if (num > n)
        {
          puts("NO");
          return 0;
        }

        s.push(num++);
        v.push_back('+');
        if (s.top() == arr[i])
        {
          s.pop();
          v.push_back('-');
          break;
        }
      }
    }
    else if (s.top() == arr[i])
    {
      s.pop();
      v.push_back('-');
    }
  }

  for (int i = 0; i < v.size(); i++)
  {
    printf("%c\n", v[i]);
  }

  return 0;
}