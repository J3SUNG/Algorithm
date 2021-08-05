#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

string sum(string x, string y)
{
  int num;
  int carry = 0;
  string result;

  reverse(x.begin(), x.end());
  reverse(y.begin(), y.end());

  while (x.length() < y.length())
  {
    x += '0';
  }
  while (x.length() > y.length())
  {
    y += '0';
  }

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

  reverse(result.begin(), result.end());

  return result;
}

int main(int argc, char *argv[])
{
  int n;
  string a;
  string b;

  string result;

  cin >> n;

  a = '0';
  b = '1';

  if (n == 0)
  {
    result = "0";
  }
  if (n == 1)
  {
    result = "1";
  }

  for (int i = 2; i <= n; ++i)
  {
    result = sum(a, b);
    a = b;
    b = result;
  }

  cout << result << endl;

  return 0;
}