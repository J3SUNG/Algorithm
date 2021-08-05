#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int arr[5][4];
  int highScore = 0;
  int sum;
  int winner;
  for (int i = 0; i < 5; ++i)
  {
    sum = 0;
    for (int j = 0; j < 4; ++j)
    {
      cin >> arr[i][j];
      sum += arr[i][j];
    }
    if (sum > highScore)
    {
      highScore = sum;
      winner = i + 1;
    }
  }

  cout << winner << " " << highScore << endl;

  return 0;
}