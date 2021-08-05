#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

queue<int> q;

void push(int x)
{
  q.push(x);
}

int pop()
{
  if (q.empty())
  {
    return -1;
  }
  int x = q.front();
  q.pop();
  return x;
}

int size()
{
  return q.size();
}

int empty()
{
  if (q.empty())
  {
    return 1;
  }
  else
  {
    return 0;
  }
}

int front()
{
  if (q.empty())
  {
    return -1;
  }
  else
  {
    return q.front();
  }
}

int back()
{
  if (q.empty())
  {
    return -1;
  }
  else
  {
    return q.back();
  }
}

int main(int argc, char *argv[])
{
  int n;
  int num;
  string s;

  cin >> n;

  while (n--)
  {
    cin >> s;

    if (s == "push")
    {
      cin >> num;
      push(num);
    }
    else if (s == "pop")
    {
      cout << pop() << endl;
    }
    else if (s == "size")
    {
      cout << size() << endl;
    }
    else if (s == "empty")
    {
      cout << empty() << endl;
    }
    else if (s == "front")
    {
      cout << front() << endl;
    }
    else if (s == "back")
    {
      cout << back() << endl;
    }
  }

  return 0;
}