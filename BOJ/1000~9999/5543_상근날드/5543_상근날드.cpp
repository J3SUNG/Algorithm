#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
  int food[3];
  int drink[2];

  cin >> food[0];
  cin >> food[1];
  cin >> food[2];
  cin >> drink[0];
  cin >> drink[1];

  food[0] = min({food[0], food[1], food[2]});
  drink[0] = min(drink[0], drink[1]);

  cout << food[0] + drink[0] - 50 << endl;

  return 0;
}