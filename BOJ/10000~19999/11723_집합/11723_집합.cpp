#include <iostream>
#include <vector>
#include <string>
using namespace std;

int bit = 0x00000;

void add(int x)
{
  bit = bit | (1 << x);
}

void remove(int x)
{
  bit = bit & (0xFFFFF - (1 << x));
}

void check(int x)
{
  int num;
  bit &(1 << x) ? num = 1 : num = 0;

  cout << num << "\n";
}

void toggle(int x)
{
  bit = bit ^ (1 << x);
}

void all()
{
  bit = 0xFFFFF;
}

void empty()
{
  bit = 0x00000;
}

int main(int argc, char *argv[])
{
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n;
  int num;
  string str;

  cin >> n;
  while (n--)
  {
    cin >> str;
    if (str != "all" && str != "empty")
    {
      cin >> num;
      --num;
    }

    if (str == "add")
    {
      add(num);
    }
    else if (str == "remove")
    {
      remove(num);
    }
    else if (str == "check")
    {
      check(num);
    }
    else if (str == "toggle")
    {
      toggle(num);
    }
    else if (str == "all")
    {
      all();
    }
    else if (str == "empty")
    {
      empty();
    }
  }

  return 0;
}