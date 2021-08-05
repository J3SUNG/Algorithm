#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct ball
{
  int num;
  int color;
  int size;
  int sum;
};

struct colorSize
{
  int size;
  int sum;
  int before;
};

bool cmp(const ball &a, const ball &b)
{
  return (a.size < b.size);
}

bool cmp2(const ball &a, const ball &b)
{
  return (a.num < b.num);
}

int main(int argc, char *argv[])
{
  int N;
  int before = 0;
  int sum = 0;

  cin >> N;

  vector<ball> b(N);
  vector<colorSize> cs(N);

  for (int i = 0; i < N; ++i)
  {
    b[i].num = i;
    cin >> b[i].color >> b[i].size;
  }

  sort(b.begin(), b.end(), cmp);

  for (int i = 0; i < N; ++i)
  {
    int index = b[i].color - 1;

    if (i > 0 && b[i].size > b[i - 1].size)
    {
      before = sum;
    }

    sum += b[i].size;

    if (b[i].size > cs[index].size)
    {
      cs[index].size = b[i].size;
      cs[index].before = cs[index].sum;
    }
    cs[index].sum += b[i].size;

    if (i > 0 && b[i].size > b[i - 1].size)
    {
      b[i].sum = sum - cs[index].sum;
    }
    else if (i > 0 && b[i].size == b[i - 1].size)
    {
      b[i].sum = before - cs[index].before;
    }
  }

  sort(b.begin(), b.end(), cmp2);

  for (int i = 0; i < N; ++i)
  {
    cout << b[i].sum << '\n';
  }

  return 0;
}
