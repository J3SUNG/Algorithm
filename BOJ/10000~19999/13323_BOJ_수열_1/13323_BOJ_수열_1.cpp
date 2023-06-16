#include <iostream>
#include <queue>
using namespace std;

int main(int argc, char *argv[]) {
	int n;
	int num;
	long long result = 0;
	priority_queue<int> pq;

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &num); 
		num -= i; 
		pq.push(num);

		if (!pq.empty() && pq.top() > num) {
			result += pq.top() - num;
			pq.pop(); 
			pq.push(num);
		}
	}
	cout << result << endl;

	return 0;
}