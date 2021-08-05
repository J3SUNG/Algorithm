#include <iostream>
#include <algorithm>
#include <cstring>
#define MAX 987654321
using namespace std;

int n;
int arr[510][2];
int DP[510][510];

int solve(int x, int y)
{
	if (x == y) {
		return 0;
	}

	if (DP[x][y] != -1) {
		return DP[x][y];
	}

	int minNum = MAX;

	for (int i = x; i < y; ++i) {
		minNum = min(minNum, solve(x, i) + solve(i + 1, y) + arr[x][0] * arr[i][1] * arr[y][1]);
	}

	DP[x][y] = minNum;

	return DP[x][y];
}

int main(int argc, char *argv[])
{
	cin >> n;

	memset(arr, 0, sizeof(arr));
	memset(DP, -1, sizeof(DP));

	for (int i = 0; i < n; ++i) {
		cin >> arr[i][0];
		cin >> arr[i][1];
	}

	solve(0, n - 1);

	cout << DP[0][n -1] << endl;

	return 0;
}