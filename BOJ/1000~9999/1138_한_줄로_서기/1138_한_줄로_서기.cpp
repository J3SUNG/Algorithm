#include <iostream>
using namespace std;

int height[10000];
int leftPeople[10000];
int people[10000];

void init()
{
  for (int i = 0; i < 10000; ++i)
  {
    height[i] = i + 1;
    leftPeople[i] = -1;
    people[i] = -1;
  }
}

int main(int argc, char *argv[])
{
  init();
  int cycle, index, count, check;
  cin >> cycle;
  for (int i = 0; i < cycle; ++i)
  {
    count = 0;
    cin >> leftPeople[i];
    check = leftPeople[i];
    for (int j = 0; j < check; ++j)
    {
      if (people[j] != -1 && people[j] < height[i])
      {
        check++;
        count++;
      }
    }
    index = leftPeople[i] + count;

    while (people[index] != -1)
    {
      index++;
    }
    people[index] = height[i];
    index = 0;
  }
  for (int i = 0; i < cycle; ++i)
  {
    cout << people[i] << " ";
  }
  return 0;
}