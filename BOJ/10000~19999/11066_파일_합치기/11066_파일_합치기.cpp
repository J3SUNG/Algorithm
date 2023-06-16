#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int DP[510][510];
int arr[510];
int sum[510];

int main()
{
	int testcase;
	cin >> testcase;

	while (testcase--)
	{
		memset(DP, 0, sizeof(DP));
		memset(arr, 0, sizeof(arr));

		int n;
		cin >> n;

		for (int i = 1; i <= n; ++i)
		{
			cin >> arr[i];
			sum[i] = sum[i - 1] + arr[i];
		}

		for (int i = 2; i <= n; ++i)
		{
			for (int j = i - 1; j > 0; --j)
			{
				DP[j][i] = 987654321;
				for (int k = j; k <= i; k++)
					DP[j][i] = min(DP[j][i], DP[j][k] + DP[k + 1][i]);

				DP[j][i] += sum[i] - sum[j - 1];
			}
		}
		cout << DP[1][n] << endl;

	}
	return 0;
}
