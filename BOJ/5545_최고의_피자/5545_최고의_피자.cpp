#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int N;      // 토핑 종류
  int A;      // 도우 가격
  int B;      // 토핑 가격
  int C;      // 도우 열량
  int D[100]; // 토핑 열량
  int value;  //총 열량
  int price;  //총 가격
  int temp;   // 스왑

  cin >> N;
  cin >> A;
  cin >> B;
  cin >> C;
  for (int i = 0; i < N; ++i)
  {
    cin >> D[i];
    int j = i;
    while (j != 0 && D[j] > D[j - 1])
    { // 내림차순 정렬
      temp = D[j - 1];
      D[j - 1] = D[j];
      D[j] = temp;
      j--;
    }
  }
  value = C;
  price = A;
  for (int i = 0; i < N; ++i)
  {
    if (C / A < D[i] / B)
    {
      C += D[i];
      A += B;
    }
  }
  cout << C / A;

  return 0;
}