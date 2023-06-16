#include <iostream>
using namespace std;

int child[200];
int check[200];

void init(int cycle)
{
  for (int i = 0; i < cycle; ++i)
  {
    check[i] = 1;
  }
}

int main(int argc, char *argv[])
{
  int cycle;
  int count = 0;
  cin >> cycle;
  init(cycle);
  for (int i = 0; i < cycle; ++i)
  {
    cin >> child[i];
  }
  for (int i = 0; i < cycle; ++i)
  {
    for (int j = i - 1; j >= 0; --j)
    {
      if (check[i] <= check[j] && child[i] > child[j])
      {
        check[i] = check[j] + 1;
      }
    }
  }
  int max = 0;
  for (int i = 0; i < cycle; ++i)
  {
    if (max < check[i])
    {
      max = check[i];
    }
  }
  cout << cycle - max << endl;
  return 0;
}