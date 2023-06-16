#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <cmath>
#define fio ios_base::sync_with_stdio(0), cin.tie(0)
#define PI 3.14159265358979323846
using namespace std;

int main(int argc, char *argv[])
{
  double n;

  double euclid;
  double taxi;

  cin >> n;

  euclid = n * n * PI;
  taxi = n * n * 2;

  cout << fixed;
  cout.precision(6);
  cout << euclid << endl;
  cout << taxi << endl;

  return 0;
}