#include <iostream>
#include <cstring>
#include <vector>
using namespace std;

int n;
int num;
int del;
int start;
vector<vector<int>> p;
vector<vector<int>> c;

int DFS(int a)
{
  int count = 0;

  if (c[a].size() == 0)
  {
    return 1;
  }

  for (int i = 0; i < c[a].size(); ++i)
  {
    count += DFS(c[a][i]);
  }

  return count;
}

int main(int argc, char *argv[])
{
  cin >> n;

  p.resize(n);
  c.resize(n);

  for (int i = 0; i < n; ++i)
  {
    cin >> num;

    if (num == -1)
    {
      start = i;
      continue;
    }

    p[i].push_back(num);
    c[num].push_back(i);
  }

  cin >> del;

  if (p[del].size() == 0)
  {
    cout << "0" << endl;
    return 0;
  }

  int parent = p[del][0];
  for (int i = 0; i < c[parent].size(); ++i)
  {
    if (c[parent][i] == del)
    {
      c[parent].erase(c[parent].begin() + i);
      break;
    }
  }

  cout << DFS(start) << endl;

  return 0;
}