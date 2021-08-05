#include <iostream>
#include <algorithm>
using namespace std;

int arr[2][20];
int DP[20];

int main(int argc, char *argv[])
{
	int next;
	int value;
	int n;
	cin >> n;

	for (int i = 0; i <= n; ++i)
	{
		arr[0][i] = 0;
		arr[1][i] = 0;
	}

	for (int i = 1; i <= n; ++i)
	{
		cin >> arr[0][i];
		cin >> arr[1][i];
	}

	for (int i = n; i > 0; --i)
	{
		next = i + arr[0][i];
		if (next > n + 1)
		{
			DP[i] = DP[i + 1];
		}
		else
		{
			DP[i] = max(DP[i + 1], DP[next] + arr[1][i]);
		}
	}

	cout << DP[1] << endl;
	return 0;
}