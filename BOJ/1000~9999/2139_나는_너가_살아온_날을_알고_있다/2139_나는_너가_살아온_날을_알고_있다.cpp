#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
  int day, month, year;
  int specialYear;
  int totalDay;
  int mArr[12] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

  while (1)
  {
    cin >> day;
    cin >> month;
    cin >> year;

    if (day == 0 && month == 0 && year == 0)
    {
      break;
    }

    specialYear = 0;
    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
    {
      specialYear = 1;
    }

    totalDay = 0;
    if (specialYear == 1 && month > 2)
    {
      ++totalDay;
    }

    for (int i = 0; i < month; ++i)
    {
      totalDay += mArr[i];
    }

    totalDay += day;

    cout << totalDay << endl;
  }
  return 0;
}