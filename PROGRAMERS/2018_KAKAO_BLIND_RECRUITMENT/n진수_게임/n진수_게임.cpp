#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>
using namespace std;

string changeNumber(int n, int num)
{
  int temp;
  string value;
  string arr[16] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

  while (num / n != 0)
  {
    temp = num % n;
    value = arr[temp] + value;
    num /= n;
  }
  value = arr[num % n] + value;

  return value;
}

string solution(int n, int t, int m, int p)
{
  int pos = p - 1;
  string answer = "";
  string temp;

  for (int i = 0; i < t * m; ++i)
  {
    temp += changeNumber(n, i);
  }

  for (int i = 0; i < t; ++i)
  {
    pos = p - 1 + (m * i);
    answer += temp[pos];
  }

  return answer;
}

int main(int argc, char *argv[])
{
  solution(10, 100, 10, 1);
  solution(10, 100, 10, 2);
  solution(10, 100, 10, 3);
  solution(10, 100, 10, 4);
  solution(10, 100, 10, 5);
  solution(10, 100, 10, 6);
  solution(10, 100, 10, 7);
  solution(10, 100, 10, 8);
  solution(10, 100, 10, 9);
  solution(10, 100, 10, 10);

  return 0;
}