#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
	int n;
	int len;
	long long int DP[110] = { 0, };
	cin >> n;

	DP[1] = 1;
	DP[2] = 1;
	DP[3] = 1;
	DP[4] = 2;
	DP[5] = 2;

	while (n-- > 0) {
		cin >> len;
		
		if (DP[len] != 0) {
			cout << DP[len] << endl;
			continue;
		}
		for (int i = 6; i <= len; ++i) {
			DP[i] = DP[i - 1] + DP[i - 5];
		}
		cout << DP[len] << endl;
	}
	return 0;
}