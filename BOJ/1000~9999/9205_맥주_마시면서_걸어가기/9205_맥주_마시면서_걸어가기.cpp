#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

int n;
int ts;
int x, y;
int flag;
int nowX, nowY;
int endX, endY;
int visit[110];
vector<pair<int, int>> mart;

void DFS(int a, int b)
{
  int num;

  num = abs(endX - a) + abs(endY - b);

  if (flag == 1 || num <= 1000)
  {
    flag = 1;
    return;
  }

  for (int i = 0; i < mart.size(); ++i)
  {
    if (visit[i] == 1)
    {
      continue;
    }

    num = abs(mart[i].first - a) + abs(mart[i].second - b);

    if (num > 1000)
    {
      continue;
    }
    else
    {
      visit[i] = 1;
      DFS(mart[i].first, mart[i].second);
    }
  }
}

int main(int argc, char *argv[])
{
  cin >> ts;

  while (ts--)
  {
    cin >> n;
    cin >> nowX >> nowY;

    mart.clear();
    memset(visit, 0, sizeof(visit));

    for (int i = 0; i < n; ++i)
    {
      cin >> x >> y;
      mart.push_back(make_pair(x, y));
    }
    cin >> endX >> endY;

    flag = 0;
    DFS(nowX, nowY);

    if (flag == 1)
    {
      cout << "happy" << endl;
    }
    else
    {
      cout << "sad" << endl;
    }
  }
  return 0;
}
