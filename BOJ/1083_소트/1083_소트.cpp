#include <iostream>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
  int n;
  int change;
  int change_index;
  int change_max;
  int next = 0;
  int num;
  vector<int> arr;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    cin >> num;
    arr.push_back(num);
  }
  cin >> change;

  while (change != 0 && next != n)
  {
    change_index = next;
    change_max = arr[change_index];

    for (int i = next; i < n; ++i)
    {
      if (arr[i] > change_max && i - next <= change)
      {
        change_index = i;
        change_max = arr[i];
      }
    }

    arr.erase(arr.begin() + change_index);
    arr.insert(arr.begin() + next, change_max);
    change -= change_index - next;
    ++next;
  }

  for (int i = 0; i < n; ++i)
  {
    cout << arr[i] << " ";
  }
  cout << endl;

  return 0;
}