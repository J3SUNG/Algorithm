#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#define MAX_BIT 67108863
using namespace std;

int n, m;
int alphabet = MAX_BIT;
vector<int> word(10000);

void solution()
{
  int num;
  int count = 0;
  char alp;
  string s;

  cin >> n;
  cin >> m;

  for (int i = 0; i < n; ++i)
  {
    cin >> s;
    sort(s.begin(), s.end());

    for (int j = 0; j < s.length(); ++j)
    {
      word[i] = word[i] | 1 << (s[j] - 97);
    }
  }

  for (int i = 0; i < m; ++i)
  {
    count = 0;

    cin >> num;
    cin >> alp;

    if (num == 1)
    {
      alphabet = alphabet & (MAX_BIT - (1 << (alp - 97)));
    }
    else
    {
      alphabet = alphabet | 1 << (alp - 97);
    }
    for (int j = 0; j < n; ++j)
    {
      if (((MAX_BIT - word[j]) | alphabet) == MAX_BIT)
      {
        ++count;
      }
    }
    cout << count << endl;
  }
}

int main(int argc, char *argv[])
{
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  solution();

  return 0;
}