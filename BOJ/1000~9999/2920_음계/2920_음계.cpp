#include <iostream>
#include <cstring>
using namespace std;

int arr[8];

int asc()
{
  for (int i = 0; i < 7; ++i)
  {
    if (arr[i] > arr[i + 1])
    {
      return 0;
    }
  }
  return 1;
}

int dec()
{
  for (int i = 0; i < 7; ++i)
  {
    if (arr[i] < arr[i + 1])
    {
      return 0;
    }
  }
  return 2;
}

int main(int argc, char *argv[])
{
  int s;

  for (int i = 0; i < 8; ++i)
  {
    cin >> arr[i];
  }

  s = asc();
  s += dec();

  switch (s)
  {
  case 0:
    cout << "mixed" << endl;
    break;
  case 1:
    cout << "ascending" << endl;
    break;
  case 2:
    cout << "descending" << endl;
    break;
  }

  return 0;
}