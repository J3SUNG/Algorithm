#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
	int n;
	int memo[1000];
	cin >> n;

	memo[0] = 0;
	memo[1] = 1;
	memo[2] = 3;

	for (int i = 3; i <= n; ++i) {
		memo[i] = (memo[i - 1] + memo[i - 2] * 2) % 10007;
	}
	
	cout << memo[n];

	return 0;
}