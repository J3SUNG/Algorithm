#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
	int sequence[1010] = { 0, };
	int memo[1010] = { 0, };
	int n;
	int result = 0;

	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> sequence[i];
		memo[i] = sequence[i];
		for (int j = i - 1; j > 0; --j) {
			if (sequence[i] > sequence[j]) {
				memo[i] = max(memo[i], memo[j] + sequence[i]);
			}
		}

	}

	for (int i = 1; i <= n; ++i) {
		result = max(result, memo[i]);
	}

	cout << result << endl;
	return 0;
}