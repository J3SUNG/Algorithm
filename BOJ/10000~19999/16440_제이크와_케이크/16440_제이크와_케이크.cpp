#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int a = 0;
  int b = 0;
  string s;

  cin >> n;
  cin >> s;

  for (int i = 0; i < n / 2; ++i)
  {
    if (s[i] == 's')
    {
      ++a;
    }
    else
    {
      ++b;
    }
  }

  if (a == b)
  {
    cout << "1" << endl;
    cout << n / 2 << endl;
  }
  else
  {
    cout << "2" << endl;
    for (int i = n / 2; i < n; ++i)
    {
      if (s[i] == 's')
      {
        ++a;
      }
      else
      {
        ++b;
      }

      if (s[i - n / 2] == 's')
      {
        --a;
      }
      else
      {
        --b;
      }

      if (a == b)
      {
        cout << i - n / 2 + 1 << " " << i + 1 << endl;
        break;
      }
    }
  }

  return 0;
}