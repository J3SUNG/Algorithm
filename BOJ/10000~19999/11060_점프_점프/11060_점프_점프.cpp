#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int DP[1010] = { 0, };

int main(int argc, char *argv[])
{
	int N;

	cin >> N;

	DP[1] = 1;
	for (int i = 1; i <= N; ++i) {
		int num;
		cin >> num;

		if (DP[i] == 0) {
			break;
		}

		for (int j = 1; j <= num; ++j) {
			if (i + j > 1000) {
				break;
			}
			if (DP[i + j] > DP[i] + 1 || DP[i + j] == 0) {
				DP[i + j] = DP[i] + 1;
			}
		}
	}

	if (DP[N] == 0) {
		cout << -1 << endl;
	}
	else {
		cout << DP[N] - 1 << endl;
	}

	return 0;
}
