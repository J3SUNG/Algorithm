#include <iostream>
#include <vector>
#define MAX_VALUE 987654321
using namespace std;

int main(int argc, char *argv[]){
	int n, m;
	int now, next, cost;
	vector<vector<int> > v;
	
	cin >> n >> m;
	
	v.resize(n+1, vector<int>(n+1, MAX_VALUE));
	
	for(int i=0; i<m; ++i){
		cin >> now >> next >> cost;
		
		v[now][next] = min(v[now][next], cost);
	}
	
	for(int i=1; i<=n; ++i){
		for(int j=1; j<=n; ++j){
			for(int k=1; k<=n; ++k){
				v[j][k] = min(v[j][k], v[j][i] + v[i][k]);
			}
		}
	}
	
	for(int i=1; i<=n; ++i){
		for(int j=1; j<=n; ++j){
			if(v[i][j] == MAX_VALUE || i == j){
				cout << "0 ";	
			} else { 
				cout << v[i][j] << " ";
			}
		}
		cout << endl;
	}
	
	return 0;	
}