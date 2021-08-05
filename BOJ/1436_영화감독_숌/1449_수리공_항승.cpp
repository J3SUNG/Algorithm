#include <iostream>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int count = 0;
  int title = 665;
  string s;

  cin >> n;

  while (++title)
  {
    s = to_string(title);

    if (s.find("666") != -1)
    {
      ++count;
    }

    if (count == n)
    {
      cout << title << endl;
      break;
    }
  }

  return 0;
}