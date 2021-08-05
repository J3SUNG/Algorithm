#include <iostream>
#include <string>
#include <vector>
using namespace std;

int solution(int m, int n, vector<string> board)
{
  int answer = 0;
  bool check = true;
  vector<string> temp;

  while (check)
  {
    check = false;
    temp = board;
    for (int i = 0; i < m - 1; ++i)
    {
      for (int j = 0; j < n - 1; ++j)
      {
        char c = board[i][j];
        if (board[i][j] != ' ' && board[i][j + 1] == c && board[i + 1][j] == c && board[i + 1][j + 1] == c)
        {
          check = true;
          temp[i][j] = ' ';
          temp[i][j + 1] = ' ';
          temp[i + 1][j] = ' ';
          temp[i + 1][j + 1] = ' ';
        }
      }
    }

    for (int i = 1; i < m; ++i)
    {
      for (int j = 0; j < n; ++j)
      {
        int k = 1;
        if (temp[i][j] != ' ')
        {
          continue;
        }
        while (i - k >= 0)
        {
          if (temp[i - k][j] != ' ')
          {
            temp[i - k + 1][j] = temp[i - k][j];
            temp[i - k][j] = ' ';
            ++k;
          }
          else
          {
            temp[i - k + 1][j] = ' ';
            break;
          }
        }
      }
    }
    board = temp;
  }

  for (int i = 0; i < m; ++i)
  {
    for (int j = 0; j < n; ++j)
    {
      if (board[i][j] == ' ')
      {
        ++answer;
      }
    }
  }

  return answer;
}

int main(int argc, char *argv[])
{
  solution(4, 5, {"CCBDE", "AAADE", "AAABF", "CCBBF"});
  return 0;
}