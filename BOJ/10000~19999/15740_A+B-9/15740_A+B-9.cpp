#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int carry = 0;
int borrow = 0;
int num;
int xFlag = 0;
int yFlag = 0;
int maxSize = 0;
string x, y;
string result = "";

string zero()
{
  int count = 0;
  int i = result.length() - 1;

  while (i >= 0)
  {
    if (result[i] == '0')
    {
      ++count;
      --i;
      continue;
    }
    break;
  }

  return result.substr(0, result.size() - count);
}

string sub()
{
  for (int i = 0; i < x.length(); ++i)
  {
    if (maxSize == 2)
    {
      num = ((y[i] - '0') - (x[i] - '0') - borrow);
    }
    else
    {
      num = ((x[i] - '0') - (y[i] - '0') - borrow);
    }
    borrow = 0;
    if (num < 0)
    {
      borrow = 1;
      num += 10;
    }
    result += to_string(num);
  }

  result = zero();

  if (maxSize == 2 && yFlag == 1)
  {
    result += '-';
  }
  else if (maxSize == 1 && xFlag == 1)
  {
    result += '-';
  }

  return result;
}

string sum()
{
  for (int i = 0; i < x.length(); ++i)
  {
    num = (x[i] - '0' + y[i] - '0' + carry) % 10;
    result += to_string(num);
    carry = (x[i] - '0' + y[i] - '0' + carry) / 10;
  }
  if (carry != 0)
  {
    result += to_string(carry);
  }
  if (xFlag == 1 && yFlag == 1)
  {
    result += '-';
  }

  return result;
}

int main(int argc, char *argv[])
{

  cin >> x >> y;

  if (x[0] == '-')
  {
    xFlag = 1;
    x = x.substr(1, x.size());
  }
  if (y[0] == '-')
  {
    yFlag = 1;
    y = y.substr(1, y.size());
  }

  reverse(x.begin(), x.end());
  reverse(y.begin(), y.end());

  while (x.length() < y.length())
  {
    x += '0';
    maxSize = 2;
  }
  while (x.length() > y.length())
  {
    y += '0';
    maxSize = 1;
  }

  if (maxSize == 0)
  {
    for (int i = 0; i < x.length(); ++i)
    {
      if (x[i] < y[i])
      {
        maxSize = 2;
      }
      else if (x[i] > y[i])
      {
        maxSize = 1;
      }
    }
  }

  if ((xFlag + yFlag) % 2 != 0)
  {
    sub();
  }
  else if ((xFlag + yFlag) % 2 == 0)
  {
    sum();
  }

  reverse(result.begin(), result.end());

  if (result == "")
  {
    result = '0';
  }

  cout << result;

  return 0;
}