#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
  int x;
  cin >> x;
  if (x >= 90)
  {
    cout << "A" << endl;
  }
  else if (x >= 80)
  {
    cout << "B" << endl;
  }
  else if (x >= 70)
  {
    cout << "C" << endl;
  }
  else if (x >= 60)
  {
    cout << "D" << endl;
  }
  else
  {
    cout << "F" << endl;
  }

  return 0;
}