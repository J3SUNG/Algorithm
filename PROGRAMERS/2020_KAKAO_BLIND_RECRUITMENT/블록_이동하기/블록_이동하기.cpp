#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int area;
int check[100][100][2] = {10000};
int direction[4][2] = {
    {0, 1},
    {1, 0},
    {0, -1},
    {-1, 0},
};
int spin[2][4][2] = {
    {{-1, 0}, {-1, 1}, {0, 0}, {0, 1}},
    {{0, -1}, {1, -1}, {0, 0}, {1, 0}},
};

bool checkArae(int y, int x, int d, vector<vector<int>> board)
{
  if (y < 0 || (d == 0 && y >= area) || (d == 1 && y + 1 >= area))
  {
    return false;
  }
  if (x < 0 || (d == 0 && x + 1 >= area) || (d == 1 && x >= area))
  {
    return false;
  }
  if (board[y][x] == 1 || (d == 0 && board[y][x + 1] == 1) || (d == 1 && board[y + 1][x] == 1))
  {
    return false;
  }
  return true;
}

int solution(vector<vector<int>> board)
{
  queue<vector<int>> q;
  area = board.size();

  fill(check[0][0], check[100][0], 10000);
  check[0][0][0] = 0;

  q.push({0, 0, 0, 0});

  while (!q.empty())
  {
    int y = q.front()[0];
    int x = q.front()[1];
    int d = q.front()[2];
    int c = q.front()[3];

    q.pop();

    for (int i = 0; i < 4; ++i)
    {
      int moveY = y + direction[i][0];
      int moveX = x + direction[i][1];
      int moveC = c + 1;
      if (!checkArae(moveY, moveX, d, board))
      {
        continue;
      }
      if (check[moveY][moveX][d] <= c)
      {
        continue;
      }
      check[moveY][moveX][d] = moveC;
      if ((d == 0 && moveX == area - 2 && moveY == area - 1) || (d == 1 && moveX == area - 1 && moveY == area - 2))
      {
        return moveC;
      }
      q.push({moveY, moveX, d, moveC});
    }
    for (int i = 0; i < 4; ++i)
    {
      int spinY = spin[d][i][0] + y;
      int spinX = spin[d][i][1] + x;
      int spinD;
      int spinC = c + 1;
      if (d == 0)
      {
        int spinD = 1;

        if (i < 2 && (!checkArae(y, x, 0, board) || !checkArae(y - 1, x, 0, board)))
        {
          continue;
        }
        if (i >= 2 && (!checkArae(y, x, 0, board) || !checkArae(y + 1, x, 0, board)))
        {
          continue;
        }
        if (check[spinY][spinX][spinD] <= spinC)
        {
          continue;
        }
        check[spinY][spinX][spinD] = spinC;
        if ((spinD == 0 && spinX == area - 2 && spinY == area - 1) || (spinD == 1 && spinX == area - 1 && spinY == area - 2))
        {
          return spinC;
        }
        q.push({spinY, spinX, spinD, spinC});
      }
      else
      {
        int spinD = 0;

        if (i < 2 && (!checkArae(y, x - 1, 0, board) || !checkArae(y + 1, x - 1, 0, board)))
        {
          continue;
        }
        if (i >= 2 && (!checkArae(y, x, 0, board) || !checkArae(y + 1, x, 0, board)))
        {
          continue;
        }
        if (check[spinY][spinX][spinD] <= spinC)
        {
          continue;
        }
        check[spinY][spinX][spinD] = spinC;
        if ((spinD == 0 && spinX == area - 2 && spinY == area - 1) || (spinD == 1 && spinX == area - 1 && spinY == area - 2))
        {
          return spinC;
        }
        q.push({spinY, spinX, spinD, spinC});
      }
    }
  }

  return 0;
}

int main(int argc, char *argv[])
{
  // vector<vector<int>> board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
  // vector<vector<int>> board = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}};
  // vector<vector<int>> board = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 1}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}};
  // vector<vector<int>> board = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0}};
  // vector<vector<int>> board = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}};
  // vector<vector<int>> board = {{0, 0, 0, 0, 1, 0}, {0, 0, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
  vector<vector<int>> board = {{0, 0, 1, 1, 1},
                               {0, 0, 1, 1, 1},
                               {0, 1, 1, 1, 1},
                               {0, 0, 0, 0, 0},
                               {0, 0, 1, 0, 0}};

  cout
      << solution(board) << endl;
  return 0;
}