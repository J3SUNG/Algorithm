#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int ts;
  int n;
  int flag;
  int current;
  int next;
  char s[10010];
  vector<string> v;

  scanf("%d", &ts);

  while (ts--)
  {
    flag = 0;

    scanf("%d", &n);

    for (int i = 0; i < n; ++i)
    {
      scanf("%s", &s);
      v.push_back(s);
    }

    sort(v.begin(), v.end());

    for (int i = 0; i < n - 1; ++i)
    {
      current = v[i].length();
      next = v[i + 1].length();
      if (current >= next)
      {
        continue;
      }
      if (v[i + 1].substr(0, current) == v[i])
      {
        printf("NO\n");
        flag = 1;
        break;
      }
    }

    if (flag == 0)
    {
      printf("YES\n");
    }

    v.clear();
  }

  return 0;
}