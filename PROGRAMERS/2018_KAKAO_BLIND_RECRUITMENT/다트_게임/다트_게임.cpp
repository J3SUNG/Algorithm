#include <iostream>
#include <string>
using namespace std;

int solution(string dart)
{
  int num = 0;
  int prevNum = 0;
  int answer = 0;
  int length = dart.length();
  bool check = false;

  for (int i = 0; i < length; ++i)
  {
    if (dart[i] >= '0' && dart[i] <= '9')
    {
      if (check)
      {
        !check;
        answer += num;
        prevNum = num;
        num = 0;
      }
      num = dart[i] - '0';
      if (dart[i] == '1' && dart[i + 1] == '0')
      {
        num = 10;
        ++i;
      }
      check = true;
      continue;
    }
    if (dart[i] == 'S')
    {
      continue;
    }
    if (dart[i] == 'D')
    {
      num = num * num;
      continue;
    }
    if (dart[i] == 'T')
    {
      num = num * num * num;
      continue;
    }
    if (dart[i] == '*')
    {
      num *= 2;
      answer += prevNum;
      continue;
    }
    if (dart[i] == '#')
    {
      num *= -1;
      continue;
    }
  }

  return answer + num;
}

int main(int argc, char *argv[])
{
  string dartResult = "1D2S#10S";
  solution(dartResult);
  return 0;
}