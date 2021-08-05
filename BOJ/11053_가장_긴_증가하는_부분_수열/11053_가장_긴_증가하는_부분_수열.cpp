#include <iostream>
#include <algorithm>
using namespace std;

int maxNum = -987654321;
int num[1010];
int memo[1010];

void init()
{
	for (int i = 0; i < 1010; ++i) {
		num[i] = 0;
		memo[i] = 1;
	}
}

int main(int argc, char *argv[])
{
	init();
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> num[i];
	}
	for (int i = 1; i < n; ++i) {
		for (int j = i - 1; j >= 0; --j) {
			if (memo[i] <= memo[j] && num[i] > num[j]) {
				memo[i] = memo[j] + 1;
			}
		}
	}
	for (int i = 0; i < n; ++i) {
		maxNum = max(maxNum, memo[i]);
	}
	cout << maxNum;

	return 0;
}