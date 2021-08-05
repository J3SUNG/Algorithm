#include <iostream>
using namespace std;

int memo[2][3];
int temp[2][3];
int n;
int l = 0;
int a = 0;

void insertValue()
{
  memo[0][0] = temp[0][0];
  memo[1][0] = temp[1][0];
  memo[0][1] = temp[0][1];
  memo[0][2] = temp[0][2];
  memo[1][1] = temp[1][1];
  memo[1][2] = temp[1][2];
  for (int i = 0; i < 2; ++i)
  {
    for (int j = 0; j < 3; ++j)
    {
      temp[i][j] = 0;
    }
  }
}

void init()
{
  for (int i = 0; i < 2; ++i)
  {
    for (int j = 0; j < 3; ++j)
    {
      memo[i][j] = 0;
      temp[i][j] = 0;
    }
  }
}

void printCount()
{
  int count = 0;

  for (int i = 0; i < 2; ++i)
  {
    for (int j = 0; j < 3; ++j)
    {
      count += memo[i][j];
    }
  }
  count %= 1000000;
  cout << count << endl;
}

void remainder()
{
  memo[0][0] %= 1000000;
  memo[0][1] %= 1000000;
  memo[0][2] %= 1000000;
  memo[1][0] %= 1000000;
  memo[1][1] %= 1000000;
  memo[1][2] %= 1000000;
}

void ola(int x) // x=지각, y=결석, z=출결정보, l=숫자의갯수
{
  if (x == n && n != 0)
  {
    return;
  }
  if (n < 1)
  {
    memo[0][0]++;
    return;
  }
  if (x == 0)
  {
    memo[0][0]++;
    memo[0][1]++;
    memo[1][0]++;
  }
  else
  {
    temp[0][0] += memo[0][0]; // 출석
    temp[1][0] += memo[0][0]; // 지각
    temp[0][1] += memo[0][0]; // 결석

    temp[1][0] += memo[1][0]; // 출석
    //temp[2][0] += memo[1][0];	// 지각
    temp[1][1] += memo[1][0]; // 결석

    temp[0][0] += memo[0][1]; // 출석
    temp[1][0] += memo[0][1]; // 지각
    temp[0][2] += memo[0][1]; // 결석

    temp[0][0] += memo[0][2]; // 출석
    temp[1][0] += memo[0][2]; // 지각
    //temp[0][3] += memo[0][2];	// 결석

    temp[1][0] += memo[1][1]; // 출석
    //temp[2][0] += memo[1][1];	// 지각
    temp[1][2] += memo[1][1]; // 결석

    temp[1][0] += memo[1][2]; // 출석
    //temp[2][2] += memo[1][2];	// 지각
    //temp[1][3] += memo[1][2];	// 결석

    insertValue();
    remainder();
  }

  ola(++x);
}

int main(int argc, char *argv[])
{
  cin >> n;
  init();
  ola(0);
  printCount();

  return 0;
}