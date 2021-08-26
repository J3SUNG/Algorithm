#include <iostream>
#include <vector>
#include <queue>
#define MAX_VALUE 987654321
using namespace std;

int main(int argc, char *argv[])
{
	int n, m;
	int start, destination;
	int now, next, cost;
	int num;
	int go;
	int location;
	int count = 2;
	vector<int> city;
	vector<vector<pair<int, int> > > v;
	vector<int> d;
	vector<int> pre;
	queue<int> q;
		
	cin >> n >> m;
	
	v.resize(n+1);	
	d.resize(n+1);
	pre.resize(n+1);
	fill(d.begin(), d.end(), MAX_VALUE);
	
	for(int i=0; i<m; ++i){
		cin >> now >> next >> cost;
		v[now].push_back({next, cost});	
	}
		
	cin >> start >> destination;
	
	d[start] = 0;
	q.push(start);

	
	while(!q.empty()){
		num = q.front(); 
		q.pop();
		for(int i=0; i<v[num].size(); ++i){
			go = v[num][i].first;
			if(d[go] > d[num] + v[num][i].second){
				d[go] = d[num] + v[num][i].second;
				pre[go] = num;
				q.push(go);
			}		
		}	
	}
	
	cout << d[destination] << endl;
	
	location = pre[destination];
	city.push_back(destination);
	while(1){
		if(location != start) {
			city.push_back(location);		
			location = pre[location];
			++count;	
		} else {
			break;	
		}
	}
	city.push_back(start);
	
	cout << count << endl;
	for(int i=city.size()-1; i>=0; --i){
		cout << city[i] << " ";	
	}
	
	return 0;
}