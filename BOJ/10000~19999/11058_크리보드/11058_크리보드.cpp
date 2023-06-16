#include<iostream>
#include<algorithm>
typedef long long ll;

using namespace std;

int main(int argc, char *argv[]) {
	int n;
	int maxNum;
	ll DP[101];

	cin >> n;

	DP[0] = 0;
	DP[1] = 1;
	DP[2] = 2;
	DP[3] = 3;
	DP[4] = 4;
	DP[5] = 5;

	for (int i = 6; i <= n; i++) {
		DP[i] = max({ DP[i - 1] + 1, DP[i - 3] * 2, DP[i - 4] * 3, DP[i - 5] * 4 });
	}

	cout << DP[n] << endl;

	return 0;
}