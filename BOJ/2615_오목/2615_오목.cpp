#include <iostream>
#include <string>
using namespace std;

bool flag = false;
int x, y;
int black = 1;
int white = 2;
int map[19][19];
int chkMove[4][6][2] = {{{1, 0}, {2, 0}, {3, 0}, {4, 0}, {-1, 0}, {5, 0}},
                        {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, -1}, {0, 5}},
                        {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {-1, -1}, {5, 5}},
                        {{-1, 1}, {-2, 2}, {-3, 3}, {-4, 4}, {1, -1}, {-5, 5}}};

bool check(int color)
{
  for (int i = 0; i < 19; ++i)
  {
    for (int j = 0; j < 19; ++j)
    {
      if (map[i][j] != color)
      {
        continue;
      }

      for (int k = 0; k < 4; ++k)
      {
        for (int l = 0; l < 6; ++l)
        {
          int nextX = j + chkMove[k][l][1];
          int nextY = i + chkMove[k][l][0];

          if (l > 3)
          {
            if (nextX < 0 || nextY < 0 || nextX > 18 || nextY > 18 || map[nextY][nextX] != color)
            {
              if (l == 5)
              {
                x = j;
                y = i;
                flag = true;
                return true;
              }
              continue;
            }
            else
            {
              break;
            }
          }

          if (nextX < 0 || nextY < 0 || nextX > 18 || nextY > 18)
          {
            break;
          }

          if (l < 4 && map[nextY][nextX] != color)
          {
            break;
          }
        }
      }
    }
  }

  return false;
}

int main(int argc, char *argv[])
{
  bool b;
  bool w;

  for (int i = 0; i < 19; ++i)
  {
    for (int j = 0; j < 19; ++j)
    {
      cin >> map[i][j];
    }
  }

  b = check(black);

  if (!flag)
  {
    w = check(white);
  }

  if (b == 0 && w == 0)
  {
    cout << 0 << endl;
  }
  else if (b == 1)
  {
    cout << "1" << endl;
    cout << y + 1 << " " << x + 1 << endl;
  }
  else
  {
    cout << "2" << endl;
    cout << y + 1 << " " << x + 1 << endl;
  }

  return 0;
}