#include <iostream>
#include <bitset>
using namespace std;

int main(int argc, char *argv[])
{
  int ts;
  int num;

  cin >> ts;

  while (ts--)
  {
    cin >> num;
    for (int i = 0; i < 30; i++)
    {
      if (num & (1 << i))
      {
        cout << i << ' ';
      }
    }
  }

  return 0;
}