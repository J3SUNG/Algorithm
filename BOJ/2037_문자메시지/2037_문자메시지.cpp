#include <iostream>
#include <algorithm>
#include <fstream>
#include <cstring>
#include <string>

using namespace std;

int main(int argc, char *argv[])
{
  int p, w;
  int now = 0;
  int result = 0;
  int num[2][27] = {{1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4},
                    {1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9}};
  string s;
  scanf("%d%d", &p, &w);
  getchar();
  getline(cin, s);

  for (int i = 0; i < s.length(); ++i)
  {
    int index = -1;
    if (s[i] >= 'A' && s[i] <= 'Z')
    {
      index = s[i] - 'A' + 1;
    }
    if (s[i] == ' ')
    {
      index = 0;
    }
    if (index != -1)
    {
      result += num[0][index] * p;
      if (now == num[1][index] && index != 0)
      {
        result += w;
      }
      now = num[1][index];
    }
  }

  cout << result << endl;

  return 0;
}