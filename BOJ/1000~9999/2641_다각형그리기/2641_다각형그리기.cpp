#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int cycle;
  int count = 0;
  string s;
  string ori1 = "";
  string ori2 = "";
  string result[110];

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    char c;
    cin >> c;

    ori1 += c;
    ori2 += (c + 1) % 4 + 1 + '0';
  }
  reverse(ori2.begin(), ori2.end());

  cin >> cycle;

  while (cycle--)
  {
    s = "";
    for (int i = 0; i < n; ++i)
    {
      char c;
      cin >> c;

      s += c;
    }

    string temp = s;

    for (int i = 0; i < n; ++i)
    {
      if (temp == ori1 || temp == ori2)
      {
        result[count] = s;
        ++count;
        break;
      }
      temp = temp.substr(1, temp.length()) + temp[0];
    }
  }

  cout << count << endl;

  for (int i = 0; i < count; ++i)
  {
    for (int j = 0; j < ori1.length(); ++j)
    {
      cout << result[i][j];
      if (j < ori1.length() - 1)
      {
        cout << " ";
      }
    }
    cout << endl;
  }

  return 0;
}