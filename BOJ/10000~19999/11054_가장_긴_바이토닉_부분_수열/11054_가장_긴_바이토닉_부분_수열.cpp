#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
	int n;
	int mNum = 0;
	int seq[1010];
	int DP[1010] = { 1, };

	for (int i = 0; i < 1010; ++i) {
		seq[i] = 0;
		DP[i] = 1;
	}

	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> seq[i];
	}

	for (int i = 1; i <= n; ++i) {
		for (int j = i; j > 0; --j) {
			if (seq[j] < seq[i] && DP[j] >= DP[i]){
				DP[i] = DP[j] + 1;
			}
		}
	}

	for (int i = 1; i <= n; ++i) {
		for (int j = i; j > 0; --j) {
			if (seq[j] > seq[i] && DP[j] >= DP[i]) {
				DP[i] = DP[j] + 1;
			}
		}
	}

	for (int i = 1; i <= n; ++i) {
		mNum = max(mNum, DP[i]);
	}
	
	cout << mNum << endl;

	return 0;
}