#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool visit[1000001];
int check[1000001][2];
vector<vector<int> > v;

void dfs(int now)
{
	int next;
	
	visit[now] = true;
	check[now][1] = 1;
	
	for(int i=0; i<v[now].size(); ++i) {
		next = v[now][i];	
		if(visit[next]) {
			continue;
		}
		dfs(next);
		check[now][0] += check[next][1];
		check[now][1] += min(check[next][0], check[next][1]);
	}
}

int main(int argc, char *argv[])
{
	int n;
	int a, b;
	
	cin >> n;
	
	v.resize(n + 1);
	
	for(int i=1; i<n; ++i){
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	
	dfs(1);
	
	cout << min(check[1][0], check[1][1]) << endl;;
		
	return 0;
}