#include <iostream>
#include <cstring>
using namespace std;

int seat[50];
int DP[50];

int main(int argc, char *argv[])
{
	memset(seat, 0, sizeof(seat));
	memset(DP, 0, sizeof(DP));

	int n;
	int vipNum;
	int vip;
	int result = 1;

	cin >> n;
	cin >> vipNum;
	while (vipNum--) {
		cin >> vip;
		DP[vip] = -1;
	}

	DP[0] = -1;
	DP[n + 1] = -1;

	for (int i = 1; i <= n; ++i) {
		if (DP[i] == -1) {
			continue;
		}
		if (DP[i - 1] == -1) {
			DP[i] = 1;
			continue;
		}
		if(i > 1 && DP[i - 2] == -1){
			DP[i] = 2;
			continue;
		}
		DP[i] = DP[i - 1] + DP[i - 2];
	}

	for (int i = 1; i <= n + 1; ++i) {
		if (DP[i] == -1 && DP[i - 1] != -1) {
			result *= DP[i - 1];
		}
	}

	cout << result << endl;

	return 0;
}