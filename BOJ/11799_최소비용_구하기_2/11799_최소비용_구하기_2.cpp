#include <iostream>
#include <vector>
#include <queue>
#define MAX_VALUE 987654321
using namespace std;

struct pq_data
{
	int node, cost;
};

struct compare {
	bool operator()(pq_data a, pq_data b)
		{
			return a.cost < b.cost;
		}
};

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
	priority_queue<pq_data, vector<pq_data>, compare> pq;
		
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
	pq.push({start, 0});
	while(!pq.empty()){
		now = pq.top().node; 
		cost = pq.top().cost;
		pq.pop();
		for(int i=0; i<v[now].size(); ++i){
			next = v[now][i].first;
			if(d[next] > d[now] + v[now][i].second){
				d[next] = d[now] + v[now][i].second;
				pq.push({next,  d[next]});	
				pre[next] = now;
			}
		}
		
		if(go == destination){
			break;
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