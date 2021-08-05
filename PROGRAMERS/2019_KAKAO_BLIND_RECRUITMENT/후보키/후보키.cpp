#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

vector<vector<string>> globalRelation;
vector<string> check;
int column;
int row;

bool compareAsc(string a, string b)
{
  return a > b;
}

bool compareCheck(string a, string b)
{
  return a.length() < b.length();
}

bool func(vector<string> v)
{
  sort(v.begin(), v.end(), compareAsc);
  for (int i = 0; i < column - 1; ++i)
  {
    if (v[i] == v[i + 1])
    {
      return false;
    }
  }
  return true;
}

void deduplication()
{
  for (int i = 0; i < check.size(); ++i)
  {
    string a = check[i];
    for (int j = 0; j < check.size(); ++j)
    {
      if (i == j)
      {
        continue;
      }

      string b = check[j];
      int aLen = check[i].length();
      int bLen = check[j].length();
      int count = 0;

      for (int k = 0; k < aLen; ++k)
      {
        for (int l = 0; l < bLen; ++l)
        {
          if (a[k] == b[l])
          {
            ++count;
          }
        }
      }
      if (count == aLen)
      {
        check.erase(check.begin() + j);
        --j;
      }
    }
  }
}

void DFS(string s, int n, vector<string> v)
{
  for (int i = 0; i < column; ++i)
  {
    v[i] += globalRelation[i][n];
  }

  if (func(v))
  {
    check.push_back(s);
  }

  for (int i = n + 1; i < row; ++i)
  {
    DFS(s + to_string(i), i, v);
  }
}

int solution(vector<vector<string>> relation)
{
  vector<string> v = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
  globalRelation = relation;
  int answer = 0;

  column = relation.size();
  row = relation[0].size();

  for (int i = 0; i < row; ++i)
  {
    DFS(to_string(i), i, v);
  }

  sort(check.begin(), check.end(), compareCheck);

  deduplication();

  answer = check.size();

  return answer;
}

int main(int argc, char *argv[])
{
  vector<vector<string>> v = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};

  cout << solution(v) << endl;

  return 0;
}