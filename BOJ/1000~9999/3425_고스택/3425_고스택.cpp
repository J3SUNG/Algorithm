#include <iostream>
#include <cstring>
#include <algorithm>
#include <stack>
#include <vector>
#include <queue>
#define MAX 1000000000
using namespace std;
typedef long long ll;

stack<ll> s;
vector<string> v;
vector<ll> numStore;

int NUM(ll x)
{
  s.push(x);

  return 0;
}

int POP()
{
  if (s.empty())
  {
    return 1;
  }

  s.pop();

  return 0;
}

int INV()
{
  if (s.empty())
  {
    return 1;
  }

  ll x = -(s.top());
  s.pop();
  s.push(x);

  return 0;
}

int DUP()
{
  if (s.empty())
  {
    return 1;
  }

  s.push(s.top());

  return 0;
}

int SWP()
{
  if (s.empty())
  {
    return 1;
  }

  ll x = s.top();
  s.pop();

  if (s.empty())
  {
    return 1;
  }

  ll y = s.top();
  s.pop();
  s.push(x);
  s.push(y);

  return 0;
}

int ADD()
{
  if (s.empty())
  {
    return 1;
  }

  ll x = s.top();
  s.pop();

  if (s.empty())
  {
    return 1;
  }

  x += s.top();
  s.pop();
  s.push(x);

  return 0;
}

int SUB()
{
  if (s.empty())
  {
    return 1;
  }

  ll x = s.top();
  s.pop();

  if (s.empty())
  {
    return 1;
  }

  x = s.top() - x;
  s.pop();
  s.push(x);

  return 0;
}

int MUL()
{
  if (s.empty())
  {
    return 1;
  }

  ll x = s.top();
  s.pop();

  if (s.empty())
  {
    return 1;
  }

  x *= s.top();
  s.pop();
  s.push(x);

  return 0;
}

int DIV()
{
  int neg = 0;

  if (s.empty())
  {
    return 1;
  }

  ll x = s.top();

  if (x < 0)
  {
    ++neg;
  }

  s.pop();

  if (s.empty())
  {
    return 1;
  }

  ll y = s.top();

  if (y < 0)
  {
    ++neg;
  }

  if (x == 0)
  {
    return 1;
  }

  x = y / x;
  if (neg == 1)
  {
    x = -(abs(x));
  }
  else
  {
    x = abs(x);
  }

  s.pop();
  s.push(x);

  return 0;
}

int MOD()
{
  int neg = 0;

  if (s.empty())
  {
    return 1;
  }

  ll x = s.top();

  s.pop();

  if (s.empty())
  {
    return 1;
  }

  ll y = s.top();

  if (y < 0)
  {
    ++neg;
  }

  if (x == 0)
  {
    return 1;
  }

  x = y % x;
  if (neg == 1)
  {
    x = -(abs(x));
  }
  else
  {
    x = abs(x);
  }

  s.pop();
  s.push(x);

  return 0;
}

int main(int argc, char *argv[])
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n;
  int first;
  int errChk;
  int c;
  ll x;
  string str;

  while (1)
  {
    errChk = 0;
    while (1)
    {
      cin >> str;

      if (str == "NUM")
      {
        cin >> x;
        numStore.push_back(x);
      }
      if (str == "QUIT")
      {
        return 0;
      }
      if (str == "END")
      {
        break;
      }

      v.push_back(str);
    }

    cin >> n;

    while (n--)
    {
      c = 0;

      cin >> first;

      s.push(first);

      for (int i = 0; i < v.size(); ++i)
      {
        if (v[i] == "NUM")
        {
          errChk = NUM(numStore[c]);
          ++c;
        }
        else if (v[i] == "POP")
        {
          errChk = POP();
        }
        else if (v[i] == "INV")
        {
          errChk = INV();
        }
        else if (v[i] == "DUP")
        {
          errChk = DUP();
        }
        else if (v[i] == "SWP")
        {
          errChk = SWP();
        }
        else if (v[i] == "ADD")
        {
          errChk = ADD();
        }
        else if (v[i] == "SUB")
        {
          errChk = SUB();
        }
        else if (v[i] == "MUL")
        {
          errChk = MUL();
        }
        else if (v[i] == "DIV")
        {
          errChk = DIV();
        }
        else if (v[i] == "MOD")
        {
          errChk = MOD();
        }

        if (!s.empty() && (s.top() > MAX || s.top() < -MAX))
        {
          errChk = 1;
        }
        if (errChk == 1)
        {
          break;
        }
      }

      if (errChk == 1 || s.size() != 1)
      {
        cout << "ERROR\n";
      }
      else
      {
        cout << s.top() << "\n";
      }
      while (!s.empty())
      {
        s.pop();
      }
    }

    numStore.clear();
    v.clear();
    cout << endl;
  }

  return 0;
}