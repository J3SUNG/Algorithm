#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int n;
int ans = 987654321;
vector<vector<int> > v;

void dfs(int loc, int c, int bit)
{
  if(c == n/2){
    int a = 0;
    int b = 0;
    for(int i=0; i<n; ++i){
      for(int j=i+1; j<n; ++j){
        if((1<<i & bit) == 0){
          if((1<<j & bit) == 0){
            a += v[i][j];
            a += v[j][i];
          }
        } else {
          if((1<<j & bit) != 0){
            b += v[i][j];
            b += v[j][i];
          }
        }        
      }
    }
    ans = min(ans, abs(a-b));
    return;
  }
  for(int i=loc; i<n; ++i){
    if((1<<i & bit) == 0){
      dfs(i, c+1, (bit | 1<<i));
    }
  }
}

int main(int argc, char *argv[])
{
  int bit;
  
  cin >> n;

  v.resize(n, vector<int>(n,0));

  for(int i=0; i<n; ++i){
    for(int j=0; j<n; ++j){
      cin >> v[i][j];
    }
  }

  for(int i=0; i<n; ++i){
    dfs(i, 1, 1<<i);
  }

  cout << ans << endl;

  return 0;
}