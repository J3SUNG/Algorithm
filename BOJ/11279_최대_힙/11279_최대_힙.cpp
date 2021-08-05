#include <iostream>
#include <string>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char *argv[])
{
	int n;
	int num;
	priority_queue<int> q;
	
	scanf("%d", &n);

	while (n--) {
		scanf("%d", &num);
		if (num == 0) {
			if (q.empty()) {
				printf("0\n");
			}
			else {
				printf("%d\n", q.top());
				q.pop();
			}
		}
		else {
			q.push(num);
		}
	}

	return 0;
}