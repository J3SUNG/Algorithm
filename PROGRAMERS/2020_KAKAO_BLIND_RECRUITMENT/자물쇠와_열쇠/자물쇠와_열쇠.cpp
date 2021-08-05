#include <iostream>
#include <string>
#include <vector>
#include <cstring>
using namespace std;

vector<vector<vector<int>>> globalLock;

void rotate()
{
  vector<vector<int>> lock(globalLock[0]);
  int lockLen = lock.size();

  int count = 1;
  while (count <= 3)
  {
    for (int i = 0; i < lockLen / 2; ++i)
    {
      for (int j = i; j < lockLen - 1 - i; ++j)
      {
        int Top = lock[i][j];

        lock[i][j] = lock[lockLen - 1 - j][i];
        lock[lockLen - 1 - j][i] = lock[lockLen - 1 - i][lockLen - 1 - j];
        lock[lockLen - 1 - i][lockLen - 1 - j] = lock[j][lockLen - 1 - i];
        lock[j][lockLen - 1 - i] = Top;
      }
    }
    globalLock.push_back(lock);
    ++count;
  }
}

bool func(vector<vector<int>> key, int y, int x, int n)
{
  vector<vector<int>> check = globalLock[n];
  int keyLen = key.size();
  int lockLen = check.size();

  for (int i = 0; i < lockLen; ++i)
  {
    for (int j = 0; j < lockLen; ++j)
    {
      if (y + i >= 0 && x + j >= 0 && y + i < keyLen && x + j < keyLen)
      {
        if (check[i][j] + key[y + i][x + j] ^ 1)
        {
          return false;
        }
      }
      else if (check[i][j] == 0)
      {
        return false;
      }
    }
  }
  return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock)
{
  globalLock.push_back(lock);

  rotate();
  int keyLen = key.size();
  int lockLen = lock.size();

  for (int i = -lockLen + 1; i < keyLen; ++i)
  {
    for (int j = -lockLen + 1; j < keyLen; ++j)
    {
      if (func(key, i, j, 0))
      {
        cout << true << endl;
        return true;
      };
      if (func(key, i, j, 1))
      {
        cout << true << endl;
        return true;
      };
      if (func(key, i, j, 2))
      {
        cout << true << endl;
        return true;
      };
      if (func(key, i, j, 3))
      {
        cout << true << endl;
        return true;
      };
    }
  }
  cout << false << endl;
  return false;
}

int main(int argc, char *argv[])
{
  vector<vector<int>> key = {{1, 0}, {0, 1}};
  vector<vector<int>> lock = {{1, 1, 1, 1}, {1, 1, 1, 0}, {1, 1, 0, 1}, {1, 1, 1, 1}};

  solution(key, lock);

  return 0;
}