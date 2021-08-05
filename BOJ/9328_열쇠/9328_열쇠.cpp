#include <iostream>
#include <cstring>
#include <string>
#include <queue>
#include <algorithm>
using namespace std;

int ts;
int n, m;
int result;
string s;
int mx[4] = {0, 0, 1, -1};
int my[4] = {1, -1, 0, 0};
bool visit[110][110];
bool key[26];
char map[110][110];
queue<pair<int, int>> q;
queue<pair<int, int>> door[26];

int main(int argc, char *argv[])
{
  cin >> ts;

  while (ts--)
  {
    result = 0;

    cin >> n >> m;

    memset(map, 0, sizeof(map));
    memset(visit, false, sizeof(visit));
    memset(key, false, sizeof(key));

    while (!q.empty())
    {
      q.pop();
    }
    for (int i = 0; i < 26; ++i)
    {
      while (!door[i].empty())
      {
        door[i].pop();
      }
    }

    for (int i = 1; i <= n; ++i)
    {
      for (int j = 1; j <= m; ++j)
      {
        cin >> map[i][j];
      }
    }

    cin >> s;

    for (int i = 0; i < s.size(); ++i)
    {
      if (s[i] == '0')
      {
        break;
      }
      key[s[i] - 'a'] = true;
    }

    q.push(make_pair(0, 0));
    visit[0][0] = true;

    while (!q.empty())
    {
      int a = q.front().first;
      int b = q.front().second;
      q.pop();

      for (int i = 0; i < 4; ++i)
      {
        int y = a + my[i];
        int x = b + mx[i];

        if (x >= 0 && x <= m + 1 && y >= 0 && y <= n + 1)
        {
          if (visit[y][x] || map[y][x] == '*')
          {
            continue;
          }

          visit[y][x] = true;

          if (map[y][x] >= 'A' && map[y][x] <= 'Z')
          {
            int index1 = map[y][x] - 'A';

            if (key[index1])
            {
              q.push(make_pair(y, x));
            }
            else
            {
              door[index1].push(make_pair(y, x));
            }
          }
          else if (map[y][x] >= 'a' && map[y][x] <= 'z')
          {
            int index2 = map[y][x] - 'a';
            q.push(make_pair(y, x));

            if (!key[index2])
            {
              key[index2] = true;

              while (!door[index2].empty())
              {
                q.push(make_pair(door[index2].front().first, door[index2].front().second));
                door[index2].pop();
              }
            }
          }
          else
          {
            q.push(make_pair(y, x));
            if (map[y][x] == '$')
            {
              ++result;
            }
          }
        }
      }
    }
    cout << result << endl;
  }

  return 0;
}