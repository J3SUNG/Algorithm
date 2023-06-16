#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
	int memo[1010] = { 1, };
	int num[1010] = { 0, };
	int result = 0;
	int n;
	cin >> n;

	for (int i = 1; i <= n; ++i) {
		cin >> num[i];
		memo[i] = 1;
		for (int j = i - 1; j > 0; --j) {
			if (num[i] < num[j] && memo[i] <= memo[j]) {
				memo[i] = memo[j] + 1;
			}
		}
	}

	for (int i = 1; i <= n; ++i) {
		result = max(result, memo[i]);
	}
	cout << result << endl;

	return 0;
}