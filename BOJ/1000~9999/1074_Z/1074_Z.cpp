#include <iostream>
#include <math.h>
using namespace std;

int n, r, c;
int result;

void recursion(int x, int y, int len)
{
  if (y == r && x == c)
  { //찾는 좌표의 결과값 출력
    cout << result << endl;
    return;
  }
  if (len == 1)
  { // +1
    result++;
    return;
  }
  if (!(y <= r && r < y + len && x <= c && c < x + len))
  { //
    result += len * len;
    return;
  }
  recursion(x, y, len / 2);                     //2사분면
  recursion(x + len / 2, y, len / 2);           //1사분면
  recursion(x, y + len / 2, len / 2);           //3사분면
  recursion(x + len / 2, y + len / 2, len / 2); //4사분면
}

int main()
{
  cin >> n;                   // 2의 n제곱 크기
  cin >> r;                   // x좌표
  cin >> c;                   // y좌표
  recursion(0, 0, pow(2, n)); // pow  =  2의 n제곱

  return 0;
}