#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2)
{
  int bit;
  string s;
  vector<string> answer;

  for (int i = 0; i < n; ++i)
  {
    s = "";
    bit = arr1[i] | arr2[i];
    for (int j = 1; j <= n; ++j)
    {
      if (bit & 1 << n - j)
      {
        s += "#";
      }
      else
      {
        s += " ";
      }
    }
    answer.push_back(s);
  }

  return answer;
}

int main(int argc, char *argv[])
{
  int n = 5;
  vector<int> arr1 = {9, 20, 28, 18, 11};
  vector<int> arr2 = {30, 1, 21, 17, 28};

  solution(n, arr1, arr2);

  return 0;
}