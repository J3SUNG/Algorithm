#include <iostream>
#include <algorithm>
#include <deque>
#include <string>
using namespace std;

deque<int> d;

void push_front_(int x)
{
  d.push_front(x);
}

void push_back_(int x)
{
  d.push_back(x);
}

int pop_front_()
{
  if (d.empty())
  {
    return -1;
  }
  else
  {
    int num = d.front();
    d.pop_front();
    return num;
  }
}

int pop_back_()
{
  if (d.empty())
  {
    return -1;
  }
  else
  {
    int num = d.back();
    d.pop_back();
    return num;
  }
}

int size_()
{
  return d.size();
}

int empty_()
{
  if (d.empty())
  {
    return 1;
  }
  else
  {
    return 0;
  }
}

int front_()
{
  if (d.empty())
  {
    return -1;
  }
  else
  {
    return d.front();
  }
}

int back_()
{
  if (d.empty())
  {
    return -1;
  }
  else
  {
    return d.back();
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

    if (s == "push_front")
    {
      cin >> num;

      push_front_(num);
    }
    else if (s == "push_back")
    {
      cin >> num;

      push_back_(num);
    }
    else if (s == "pop_front")
    {
      cout << pop_front_() << endl;
    }
    else if (s == "pop_back")
    {
      cout << pop_back_() << endl;
    }
    else if (s == "size")
    {
      cout << size_() << endl;
    }
    else if (s == "empty")
    {
      cout << empty_() << endl;
    }
    else if (s == "front")
    {
      cout << front_() << endl;
    }
    else if (s == "back")
    {
      cout << back_() << endl;
    }
  }

  return 0;
}