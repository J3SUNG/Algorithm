#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>

using namespace std;

int main(int argc, char *argv[])
{
  bool flag;
  bool arr[5010] = {
      false,
  };
  int num;
  int result;
  int x, y;
  int a[10];
  string temp;

  for (int i = 0; i < 5010; ++i)
  {
    flag = false;
    num = i;

    memset(a, -1, sizeof(a));
    while (num != 0)
    {
      ++a[num % 10];
      if (a[num % 10] > 0)
      {
        flag = true;
        break;
      }
      num /= 10;
    }

    if (!flag)
    {
      arr[i] = true;
    }
  }

  while (scanf("%d%d", &x, &y) != EOF)
  {
    result = 0;

    for (int i = x; i <= y; ++i)
    {
      if (arr[i])
      {
        ++result;
      }
    }

    cout << result << endl;
  }

  return 0;
}