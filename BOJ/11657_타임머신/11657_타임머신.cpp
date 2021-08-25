#include <iostream>
#include <cstring>
#include <algorithm>
#include <vector>
#define MAX_VALUE 987654321
using namespace std;

int main(int argc, char *argv[])
{
	int n, m;
	int a, b, c;
	int num;
	int check_cycle;
	vector<vector<int> > distance;
	vector<long long> value(510, MAX_VALUE);
	
	cin >> n >> m;
	
	distance.resize(n+1, vector<int>(n+1, MAX_VALUE));
	
	value[1] = 0;
	for(int i=0; i<m; ++i){
		cin >> a >> b >> c;	
		distance[a][b] = min(distance[a][b], c);
	}
	
	for(int i=1; i<=n; ++i){
		check_cycle = false;
		for(int j=1; j<=n; ++j){
			for(int k=0; k<=distance[j].size(); ++k){
				if(value[j] != MAX_VALUE && value[k] > value[j]+distance[j][k]){
					value[k] = value[j]+distance[j][k]; 	
					check_cycle = true;	
				}				
			}
		}
		if(i==1 && !check_cycle){
			break;
		}
	}
	
	if(check_cycle){
		cout << "-1" << endl;	
	} else {
		for(int i=2; i<=n; ++i){
			if(value[i] == MAX_VALUE){
				cout << "-1" << endl;	
			} else {
				cout << value[i] << endl;	
			}
		}
	}
	
	return 0;
}
