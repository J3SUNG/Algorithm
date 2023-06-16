#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

int N, M;
int num;
int people;
int want[110];
bool visit[110];
vector<int> v[110];

bool solve(int x)
{
  for (int i = 0; i < v[x].size(); ++i)
  {
    int index = v[x][i];

    if (visit[index])
    {
      continue;
    }
    visit[index] = true;

    if (want[index] == 0 || solve(want[index]))
    {
      want[index] = x;
      return true;
    }
  }
  return false;
}

int main()
{
  int count = 0;

  cin >> N >> M;

  memset(want, 0, sizeof(want));

  for (int i = 0; i < M; ++i)
  {
    cin >> people;
    cin >> num;
    v[people].push_back(num);
  }

  for (int i = 1; i <= N; ++i)
  {
    memset(visit, false, sizeof(visit));
    if (solve(i))
    {
      ++count;
    }
  }

  cout << count << endl;

  return 0;
}
