#include <iostream>
#include <queue>
#include <algorithm>
#define MAX_VALUE 1001
using namespace std;

struct component {
	int display, clipboard, time;	
};

int main(int argc, char *argv[])
{
	int s;
	int d, c, t;
	int result = 0;
	bool visit[MAX_VALUE][MAX_VALUE];
	queue<component> q;
	
	cin >> s;
	
	q.push({1, 0, 0});
	visit[1][0] = true;
	
	while(!q.empty()) {
		d = q.front().display;
		c = q.front().clipboard;
		t = q.front().time;
		q.pop();
		
		if(d == s) {
			result = t;
			break;
		}
		
		if(d < MAX_VALUE) {
			if(!visit[d][d]) {
				visit[d][d] = true;
				q.push({d, d, t+1});
			} 
			if(c > 0 && d + c < MAX_VALUE) {
				if(!visit[d+c][c]) {
					visit[d+c][c] = true;
					q.push({d+c, c, t+1});
				}
			}
			if(!visit[d-1][c]){
				visit[d-1][c] = true;
				q.push({d-1, c, t+1});	
			}
		}
	}
	
	cout << result << endl;
	
	return 0;
}