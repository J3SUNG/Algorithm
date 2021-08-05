#include <iostream>
using namespace std;

int n;
int x, y;
int ball[4] = {0, 1, 0, 0};

void swap(int x, int y)
{
  int temp;
  temp = ball[x];
  ball[x] = ball[y];
  ball[y] = temp;
}

int main(int argc, char *argv[])
{
  cin >> n;
  for (int i = 1; i <= n; ++i)
  {
    cin >> x >> y;
    swap(x, y);
  }

  for (int i = 1; i <= 3; ++i)
  {
    if (ball[i] == 1)
    {
      cout << i << endl;
    }
  }

  return 0;
}