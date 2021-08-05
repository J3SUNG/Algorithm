#include <iostream>
#include <algorithm>
using namespace std;

int maxNum = -987654321;
int num[10010];
int memo[10010];

void init()
{
	for (int i = 0; i < 10010; ++i) {
		num[i] = 0;
		memo[i] = 0;
	}
}

int main(int argc, char *argv[])
{
	init();
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> num[i];
		memo[i] = num[i];
	}
	memo[0] = num[0];
	for (int i = 2; i <= n; ++i) {
		for (int j = 1; j < i; ++j) {
			memo[i] = max(memo[i], memo[i - j] + memo[j]);
		}
	}
	for (int i = 1; i <= n; ++i) {
		maxNum = max(maxNum, memo[i]);
	}
	cout << maxNum;
	return 0;
}