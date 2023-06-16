#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int map[502][502];
int check[502][502];
int maxCount = 0;
int printCount = 0;

int dfs(int i, int j){
  int count = 0;
  if(map[i][j] == 0){
    return 0;
  } else if(map[i][j] == 1 && !check[i][j]) {
    count = 1;
    check[i][j] = true;
    count += dfs(i+1, j);
    count += dfs(i, j+1);
    count += dfs(i-1, j);
    count += dfs(i, j-1);
  }
  maxCount = max(maxCount, count);
  
  return count;
}

int main(int argc, char *argv[])
{
  int n, m;
  int num;
  
  cin >> n >> m;

  memset(map, 0, sizeof(map));
  memset(check, false, sizeof(check));

  for(int i=1; i<=n; ++i){
    for(int j=1;j<=m; ++j){
      cin >> num;
      map[i][j] = num; 
    }
  }

  for(int i=1; i<=n; ++i){
    for(int j=1;j<=m; ++j){
      if(dfs(i, j) != 0){
        ++printCount;
      }
    }
  }

	cout << printCount << endl;
  cout << maxCount << endl;

  return 0;
}