#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int people[10];
queue<int> q;

void print(int x, int y)
{
  for (int i = 0; i < 9; ++i)
  {
    if (i == x || i == y)
    {
      continue;
    }
    cout << people[i] << endl;
  }
}

int main(int argc, char *argv[])
{
  int sum = 0;
  int sub = 0;
  int x, y;

  for (int i = 0; i < 9; ++i)
  {
    cin >> people[i];
    sum += people[i];
  }
  sum -= 100;

  sort(people, people + 9);

  for (int i = 0; i < 9; ++i)
  {
    sub += people[i];
    x = i;
    for (int j = i + 1; j < 9; ++j)
    {
      sub += people[j];
      y = j;
      if (sum - sub == 0)
      {
        print(x, y);
        return 0;
      }
      sub -= people[j];
    }
    sub -= people[i];
  }

  return 0;
}