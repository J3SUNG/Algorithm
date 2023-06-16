#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  cin >> n;
  for (int i = 1; i < n + 1; i++)
  {
    for (int j = 0; j < i; j++)
    {
      cout << "*";
    }
    cout << "\n";
  }
  return 0;
}