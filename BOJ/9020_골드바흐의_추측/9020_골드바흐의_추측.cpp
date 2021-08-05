#include <iostream>
#define MAX_SIZE 10000

int main()
{
  int T, n;
  int not_prime_nums[MAX_SIZE + 5] = {
      0,
      1,
      0,
  };

  // 소수 구하기
  for (int p = 2; p <= MAX_SIZE; p++)
  {
    if (not_prime_nums[p] == 0)
    {
      for (int i = 2; p * i <= MAX_SIZE; i++)
        not_prime_nums[p * i] = 1;
    }
  }

  scanf("%d", &T);

  while (T--)
  {
    scanf("%d", &n);

    for (int i = n / 2; i > 0; i--)
    {
      if (not_prime_nums[i] == 0 && not_prime_nums[n - i] == 0)
      {
        printf("%d %d\n", i, n - i);
        break;
      }
    }
  }

  return 0;
}