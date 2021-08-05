#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int n, m;
  int num;

  cin >> n >> m;

  for (int i = 0; i < 5; ++i)
  {
    cin >> num;
    cout << num - n * m << " ";
  }

  return 0;
}