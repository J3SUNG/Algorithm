#include <iostream>
#include <string>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

bool compare(vector<int> a, vector<int> b)
{
  if (a[0] == b[0])
  {
    if (a[1] == b[1])
    {
      if (a[2] < b[2])
      {
        return true;
      }
    }
    if (a[1] < b[1])
    {
      return true;
    }
  }
  if (a[0] < b[0])
  {
    return true;
  }

  return false;
}

void add(vector<vector<int>> &answer, vector<int> build_frame)
{
  vector<int> temp;
  temp.push_back(build_frame[0]);
  temp.push_back(build_frame[1]);
  temp.push_back(build_frame[2]);

  answer.push_back(temp);
}

bool remove(vector<vector<int>> &answer, vector<int> build_frame)
{
  bool check[5];
  memset(check, false, sizeof(check));
  for (int i = 0; i < answer.size(); ++i)
  {
    if (build_frame[2] == 0)
    {
      if (build_frame[0] == answer[i][0] && build_frame[1] == answer[i][1] - 1 && answer[i][2] == 0)
      {
        check[0] = true;
      }
      if (build_frame[0] == answer[i][0] + 1 && build_frame[1] == answer[i][1] - 1 && answer[i][2] == 1)
      {
        check[1] = true;
        check[2] = true;
      }
      if (build_frame[0] == answer[i][0] && build_frame[1] == answer[i][1] - 1 && answer[i][2] == 1)
      {
        check[3] = true;
        check[4] = true;
      }

      if (check[0] | check[1] | check[2] | check[3] | check[4])
      {
        for (int j = 0; j < answer.size(); ++j)
        {
          if (check[0] && (build_frame[0] == answer[j][0] + 1 || build_frame[0] == answer[j][0]) && (build_frame[1] == answer[j][1] - 1 && answer[j][2] == 1))
          {
            check[0] = false;
          }

          if (build_frame[0] == answer[j][0] + 1 && build_frame[1] == answer[j][1] && answer[j][2] == 0)
          {
            check[1] = false;
            check[2] = false;
          }
          if (check[1] && build_frame[0] == answer[j][0] + 2 && build_frame[1] == answer[j][1] - 1 && answer[j][2] == 1)
          {
            check[1] = false;
          }
          if (check[2] && build_frame[0] == answer[j][0] && build_frame[1] == answer[j][1] - 1 && answer[j][2] == 1)
          {
            check[2] = false;
          }
          if (build_frame[0] == answer[j][0] - 1 && build_frame[1] == answer[j][1] && answer[j][2] == 0)
          {
            check[3] = false;
            check[4] = false;
          }
          if (check[3] && build_frame[0] == answer[j][0] - 1 && build_frame[1] == answer[j][1] - 1 && answer[j][2] == 1)
          {
            check[3] = false;
          }
          if (check[4] && build_frame[0] == answer[j][0] + 1 && build_frame[1] == answer[j][1] - 1 && answer[j][2] == 1)
          {
            check[4] = false;
          }
        }
        if (check[0] | check[1] | check[2] | check[3] | check[4])
        {
          return false;
        }
      }
    }
    else if (build_frame[2] == 1)
    {
      if (build_frame[0] == answer[i][0] && build_frame[1] == answer[i][1] && answer[i][2] == 0)
      {
        check[0] = true;
      }
      if (build_frame[0] == answer[i][0] - 1 && build_frame[1] == answer[i][1] && answer[i][2] == 0)
      {
        check[1] = true;
      }
      if (build_frame[0] == answer[i][0] + 1 && build_frame[1] == answer[i][1] && answer[i][2] == 1)
      {
        check[2] = true;
      }
      if (build_frame[0] == answer[i][0] - 1 && build_frame[1] == answer[i][1] && answer[i][2] == 1)
      {
        check[3] = true;
      }

      if (check[0] | check[1] | check[2] | check[3])
      {
        for (int j = 0; j < answer.size(); ++j)
        {
          if (check[0] && ((build_frame[0] == answer[j][0] && build_frame[1] == answer[j][1] + 1 && answer[j][2] == 0) || (build_frame[0] == answer[j][0] + 1 && build_frame[1] == answer[j][1] && answer[j][2] == 1)))
          {
            check[0] = false;
          }
          if (check[1] && ((build_frame[0] == answer[j][0] - 1 && build_frame[1] == answer[j][1] + 1 && answer[j][2] == 0) || (build_frame[0] == answer[j][0] - 1 && build_frame[1] == answer[j][1] && answer[j][2] == 1)))
          {
            check[1] = false;
          }
          if (check[2] && ((build_frame[0] == answer[j][0] + 1 && build_frame[1] == answer[j][1] + 1 && answer[j][2] == 0) || (build_frame[0] == answer[j][0] && build_frame[1] == answer[j][1] + 1 && answer[j][2] == 0)))
          {
            check[2] = false;
          }
          if (check[3] && ((build_frame[0] == answer[j][0] - 1 && build_frame[1] == answer[j][1] + 1 && answer[j][2] == 0) || (build_frame[0] == answer[j][0] - 2 && build_frame[1] == answer[j][1] + 1 && answer[j][2] == 0)))
          {
            check[3] = false;
          }
        }
        if (check[0] | check[1] | check[2] | check[3])
        {
          return false;
        }
      }
    }
  }
  return true;
}

vector<vector<int>> solution(int n, vector<vector<int>> build_frame)
{
  int check;
  vector<int> temp;
  vector<vector<int>> answer;

  for (int i = 0; i < build_frame.size(); ++i)
  {
    if (build_frame[i][3] == 1)
    {
      if (build_frame[i][2] == 0)
      {
        if (build_frame[i][1] == 0)
        {
          add(answer, build_frame[i]);
          continue;
        }
        else
        {
          for (int j = 0; j < answer.size(); ++j)
          {
            if (build_frame[i][0] == answer[j][0] && build_frame[i][1] == answer[j][1] + 1 && answer[j][2] == 0)
            {
              add(answer, build_frame[i]);
              break;
            }
            else if (build_frame[i][0] == answer[j][0] && build_frame[i][1] == answer[j][1] && answer[j][2] == 1)
            {
              add(answer, build_frame[i]);
              break;
            }
            else if (build_frame[i][0] == answer[j][0] + 1 && build_frame[i][1] == answer[j][1] && answer[j][2] == 1)
            {
              add(answer, build_frame[i]);
              break;
            }
          }
        }
      }
      else if (build_frame[i][2] == 1)
      {
        check = 0;
        for (int j = 0; j < answer.size(); ++j)
        {
          if (build_frame[i][0] == answer[j][0] && build_frame[i][1] == answer[j][1] + 1 && answer[j][2] == 0)
          {
            add(answer, build_frame[i]);
            break;
          }
          else if (build_frame[i][0] == answer[j][0] - 1 && build_frame[i][1] == answer[j][1] + 1 && answer[j][2] == 0)
          {
            add(answer, build_frame[i]);
            break;
          }
          else if (build_frame[i][0] == answer[j][0] - 1 && build_frame[i][1] == answer[j][1] && answer[j][2] == 1)
          {
            check += 1;
          }
          else if (build_frame[i][0] == answer[j][0] + 1 && build_frame[i][1] == answer[j][1] && answer[j][2] == 1)
          {
            check += 10;
          }
          if (check == 11)
          {
            add(answer, build_frame[i]);
            break;
          }
        }
      }
    }
    else if (build_frame[i][3] == 0)
    {
      for (int j = 0; j < answer.size(); ++j)
      {
        if (build_frame[i][0] == answer[j][0] && build_frame[i][1] == answer[j][1] && build_frame[i][2] == answer[j][2])
        {
          if (remove(answer, build_frame[i]))
          {
            answer.erase(answer.begin() + j);
            break;
          }
        }
      }
    }
  }

  sort(answer.begin(), answer.end(), compare);

  return answer;
}

int main(int argc, char *argv[])
{
  int n = 4;
  // vector<vector<int>> data = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
  // vector<vector<int>> data = {{1, 0, 0, 1},
  //                             {1, 1, 1, 1},
  //                             {2, 1, 0, 1},
  //                             {2, 2, 1, 1},
  //                             {5, 0, 0, 1},
  //                             {5, 1, 0, 1},
  //                             {4, 2, 1, 1},
  //                             {3, 2, 1, 1}};
  // vector<vector<int>> data = {{0, 0, 0, 1},
  //                             {0, 1, 0, 1},
  //                             {0, 2, 0, 1},
  //                             {0, 3, 1, 1},
  //                             {1, 3, 0, 1},
  //                             {0, 4, 1, 1},
  //                             {1, 4, 1, 1},
  //                             {0, 4, 0, 1},
  //                             {2, 4, 0, 1},
  //                             {0, 5, 1, 1},
  //                             {1, 5, 0, 1},
  //                             {2, 5, 1, 1},
  //                             {3, 5, 0, 1},
  //                             {1, 6, 0, 1},
  //                             {3, 6, 1, 1},
  //                             {4, 6, 0, 1},
  //                             {1, 7, 1, 1},
  //                             {3, 7, 1, 1},
  //                             {2, 7, 1, 1}};
  // vector<vector<int>> data = {{0, 0, 0, 1},
  //                             {1, 0, 0, 1},
  //                             {2, 0, 0, 1},
  //                             {3, 0, 0, 1},
  //                             {4, 0, 0, 1},
  //                             {0, 1, 1, 1},
  //                             {1, 1, 1, 1},
  //                             {2, 1, 1, 1},
  //                             {3, 1, 1, 1},
  //                             {1, 1, 0, 1},
  //                             {2, 1, 0, 1},
  //                             {3, 1, 0, 1},
  //                             {1, 2, 1, 1},
  //                             {2, 2, 1, 1},
  //                             {2, 2, 0, 1},
  //                             {1, 3, 1, 1},
  //                             {2, 3, 1, 1},
  //                             {2, 2, 0, 0},
  //                             {2, 1, 0, 0},
  //                             {2, 0, 0, 0},
  //                             {3, 1, 0, 0},
  //                             {3, 0, 0, 0},
  //                             {2, 1, 1, 0}};
  vector<vector<int>> data = {{0, 0, 0, 1},
                              {0, 0, 0, 0}};
  vector<vector<int>> answer;

  answer = solution(n, data);

  cout << answer.size() << endl;

  for (int i = 0; i < answer.size(); ++i)
  {
    for (int j = 0; j < 3; ++j)
    {
      cout << answer[i][j] << " ";
    }
    cout << endl;
  }

  return 0;
}