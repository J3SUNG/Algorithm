#include <algorithm>
#include <iostream>
#include <vector>
#include <string>
#include <cstring>
#include <algorithm>
using namespace std;

vector<int> text;
int n, k;
int bit[50];
int result = 0;

void DFS(int deep, int location, int bit)
{
  for (int i = location + 1; i < 26; ++i)
  {
    int tempBit = bit ^ (1 << i);
    if (k == deep + 1)
    {
      int count = 0;
      for (int i = 0; i < text.size(); ++i)
      {
        int compareBit = text[i] & tempBit;
        if (compareBit == 0x0000000)
        {
          ++count;
        }
      }
      result = max(result, count);
      continue;
    }
    DFS(deep + 1, i, tempBit);
  }
}

int main(int argc, char *argv[])
{
  string s;

  cin >> n >> k;

  for (int i = 0; i < n; ++i)
  {
    cin >> s;
    text.push_back(0);
    for (int j = 0; j < s.length(); ++j)
    {
      text[i] = text[i] | (1 << (s[j] - 97));
    }
  }

  DFS(0, -1, 0x3FFFFFF);

  cout << result;

  return 0;
}