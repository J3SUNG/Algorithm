#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[100001];

int findParent(int n)
{
  while(arr[n] != n){
    n = arr[n];
  }
  return n;
}

void funcSet(int a, int b)
{
  cout << a << b;
  int temp = 0;
  if(a > b){
    temp = a;
    a = b;
    b = temp;
  }

  while(temp != arr[b]){
    temp = arr[b];
    arr[b] = a;
    b = temp;
  }
}

vector<int> getTheGroups(int n, vector<string> queryType, vector<int> students1, vector<int> students2) {
  vector<int> v;
  vector<int> result;
  int num;
  int index = 0;
  int parent = 0;
  for(int i=0; i<100001; ++i){
    arr[i] = i;
  }
  for(int i=0; i<queryType.size(); ++i){
    if(queryType[i] == "Friend"){
      funcSet(students1[i], students2[i]);
    } else {
      num = findParent(students1[i]);
      v.push_back(num);
      num = findParent(students2[i]);
      v.push_back(num);

      result.push_back(0);
      for(int i=0; i<v.size(); ++i){
        if(parent == v[i]){
          continue;
        }
        parent = v[i];
        for(int j=1; j<=n; ++j){
          num = findParent(j);
          if(num == parent){
            cout << num << endl;
              ++result[index];
          }
        }
      }
      ++index;
    }
  }
  for(int i=0; i<=n; ++i){
    cout << arr[i] << endl;
  }
  return result;
}

int main(int argc, char *argv[])
{
  getTheGroups(5, {"Friend", "Friend", "Total"}, {4, 2, 2}, {1, 4, 3});
  return 0;
}