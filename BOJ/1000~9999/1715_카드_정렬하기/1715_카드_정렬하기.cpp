#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

typedef long long ll;

int main(int argc, char *argv[])
{
	int n;
	int num;
	ll f, s;
	ll result = 0;
	priority_queue<int, vector<int>, greater<int> >	pq;
	
	cin >> n;
	
	for(int i=0; i<n; ++i){
		cin >> num;
		pq.push(num);
	}

	while(pq.size() > 1){
		f = pq.top();
		pq.pop();
		s = pq.top();
		pq.pop();
		result += f + s;
		pq.push(f+s);
	}
	
	cout << result << endl;
	
	return 0;
}