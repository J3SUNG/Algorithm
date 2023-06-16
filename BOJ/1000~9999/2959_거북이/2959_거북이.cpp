#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int num;
  vector<int> v;

  for (int i = 0; i < 4; ++i)
  {
    cin >> num;
    v.push_back(num);
  }

  sort(v.begin(), v.end());

  cout << v[0] * v[2] << endl;

  return 0;
}