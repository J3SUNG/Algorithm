#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  cin >> n;
  for (int i = 2; i < n + 2; i++)
  {
    for (int j = n; j > 0; j--)
    {
      if (j < i)
      {
        cout << "*";
      }
      else
      {
        cout << " ";
      }
    }
    cout << "\n";
  }
  return 0;
}