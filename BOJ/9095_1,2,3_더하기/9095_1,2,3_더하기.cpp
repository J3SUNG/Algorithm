#include <iostream>
using namespace std;

int memo[100] = {
    0,
};
int memonum = 3;

int main(int argc, char *argv[])
{
  int cycle = 0;
  int num;
  int tmp;
  int x[3] = {1, 2, 4};
  memo[0] = 0;
  memo[1] = 1;
  memo[2] = 2;
  memo[3] = 4;

  cin >> cycle;

  for (int i = 0; i < cycle; ++i)
  {
    cin >> num;
    if (num > memonum)
    {
      x[0] = memo[memonum - 2];
      x[1] = memo[memonum - 1];
      x[2] = memo[memonum];
    }
    else
    {
      cout << memo[num] << endl;
      continue;
    }
    while (num > memonum)
    {
      ++memonum;
      memo[memonum] = x[0] + x[1] + x[2];
      x[0] = memo[memonum - 2];
      x[1] = memo[memonum - 1];
      x[2] = memo[memonum];
    }
    cout << memo[memonum] << endl;
  }
  return 0;
}