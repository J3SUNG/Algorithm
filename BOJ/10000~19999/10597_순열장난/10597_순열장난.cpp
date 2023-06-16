#include <iostream>
#include <cstring>
#include <string>
#include <stack>
using namespace std;

int maxNum;
bool flag;
string n;
int result[51];
bool arr[51];
stack<int> s;

void DFS(int num, int way)
{
  int index;

  if (flag)
  {
    return;
  }

  if (way == 0)
  {
    if (arr[n[num] - '0'] || n[num] - '0' > maxNum || n[num] - '0' == 0)
    {
      return;
    }
    s.push(n[num] - '0');
    arr[n[num] - '0'] = true;
  }
  else if (way == 1)
  {
    index = ((n[num] - '0') * 10) + n[num + 1] - '0';
    if (arr[index] || index > maxNum)
    {
      return;
    }
    s.push(index);
    arr[index] = true;
  }

  if (flag || s.size() == maxNum)
  {
    flag = true;
    return;
  }

  if (way == 0)
  {
    if (num + 1 < n.length())
    {
      DFS(num + 1, 0);
    }
    if (num + 2 < n.length())
    {
      DFS(num + 1, 1);
    }
    arr[n[num] - '0'] = false;
  }
  if (way == 1)
  {
    if (num + 1 < n.length())
    {
      DFS(num + 2, 0);
    }
    if (num + 2 < n.length())
    {
      DFS(num + 2, 1);
    }
    arr[index] = false;
  }

  if (flag)
  {
    return;
  }

  s.pop();
}

int main(int argc, char *argv[])
{
  memset(arr, 0, sizeof(arr));

  cin >> n;

  maxNum = n.length();
  if (maxNum > 9)
  {
    maxNum -= (maxNum - 9) / 2;
  }

  flag = false;

  DFS(0, 0);
  if (!flag)
  {
    DFS(0, 1);
  }

  for (int i = maxNum - 1; i >= 0; --i)
  {
    result[i] = s.top();
    s.pop();
  }

  for (int i = 0; i < maxNum; ++i)
  {
    cout << result[i] << " ";
  }

  cout << endl;

  return 0;
}