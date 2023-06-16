#include <iostream>
using namespace std;

int memo[1010][10];

void init()
{
	for (int i = 0; i < 1010; ++i) {
		for (int j = 0; j < 10; ++j) {
			memo[i][j] = 0;
		}
	}
}

int main(int argc, char *argv[])
{
	init();
	int n;
	cin >> n;

	for (int i = 1; i <= n; ++i) {
		for (int j = 0; j < 10; ++j) {
			if (i == 1) {
				memo[i][j] = 1;
			}
			else {
				for (int k = 0; k <= j; ++k) {
					memo[i][j] += memo[i - 1][j - k] % 10007;
				}
			}
		}
	}
	int max = 0;
	for (int i = 0; i < 10; ++i) {
		max += memo[n][i] % 10007;
	}
	max %= 10007;
	cout << max << endl;

	return 0;
}