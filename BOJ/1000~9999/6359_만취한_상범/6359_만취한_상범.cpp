#include <iostream>
using namespace std;

bool room[100];

void init()
{
  for (int i = 0; i < 100; ++i)
  {
    room[i] = false;
  }
}

int main(int argc, char *argv[])
{
  int cycle, num, escape, round;
  cin >> cycle;

  for (int i = 0; i < cycle; ++i)
  {
    init();
    cin >> round;
    num = 0;
    escape = 0;
    for (int j = 1; j <= round; ++j)
    {
      num = j - 1;
      while (num < round)
      {
        if (room[num] == false)
        {
          room[num] = true;
        }
        else
        {
          room[num] = false;
        }
        num += j;
      }
    }
    for (int k = 0; k < round; ++k)
    {
      if (room[k] == true)
      {
        ++escape;
      }
    }
    cout << escape << endl;
  }
  return 0;
}