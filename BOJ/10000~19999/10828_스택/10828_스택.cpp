#include <iostream>
#include <stack>
#include <string>
using namespace std;

stack<int> s;

void push(int x)
{
  s.push(x);
}

int pop()
{
  if (!s.empty())
  {
    int x = s.top();
    s.pop();
    return x;
  }
  return -1;
}

int size()
{
  return s.size();
}

int empty()
{
  if (s.empty())
  {
    return 1;
  }
  return 0;
}

int top()
{
  if (!s.empty())
  {
    return s.top();
  }
  return -1;
}

int main(int argc, char *argv[])
{
  int ts;
  string str;

  cin >> ts;

  while (ts--)
  {
    int n;
    int tmp;

    cin >> str;

    if (str == "push")
    {
      cin >> n;

      push(n);
    }
    else if (str == "pop")
    {
      tmp = pop();
      if (tmp == -1)
      {
        cout << "-1" << endl;
      }
      else
      {
        cout << tmp << endl;
      }
    }
    else if (str == "size")
    {
      cout << size() << endl;
    }
    else if (str == "empty")
    {
      cout << empty() << endl;
    }
    else if (str == "top")
    {
      tmp = top();
      if (tmp == -1)
      {
        cout << "-1" << endl;
      }
      else
      {
        cout << tmp << endl;
      }
    }
  }

  return 0;
}