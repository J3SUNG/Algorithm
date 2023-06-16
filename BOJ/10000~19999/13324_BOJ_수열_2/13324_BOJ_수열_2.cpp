#include <iostream>
#include <queue>
using namespace std;

int main(int argc, char *argv[]) 
{
	int n;
	int i;
	int num;
	int result[1000001];
	priority_queue<int> pq;
	
	cin >> n;

	for (i = 1; i <= n; i++) {
		cin >> num;
		num -= i;
		pq.push(num);
		pq.push(num);
		pq.pop();
		result[i] = pq.top();
	} 
	--i;
	
	while (--i) {
		if (result[i] > result[i + 1]) result[i] = result[i + 1];
	}
	
	for (i = 1; i <= n; i++) {
		printf("%d\n", result[i] + i);
	}

	return 0;
}