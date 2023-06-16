#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
	vector <vector<int>> input;
	int DP[100010];
	int temp[100010];
	int n;
	int w;
	int maxNum = -987654321;

	memset(DP, 0, sizeof(DP));
	memset(temp, 0, sizeof(temp));

	cin >> n;
	cin >> w;

	for (int i = 1; i <= n; ++i) {
		int weight, value;
		vector <int> v;

		cin >> weight;
		cin >> value;

		v.push_back(weight);
		v.push_back(value);

		input.push_back(v);
	}

	sort(input.begin(), input.end());

	for (int i = 0; i < n; ++i) {
		int x = input[i][0];
		for (int j = w; j >= x ; --j) {
			if (DP[j] < input[i][1] + DP[j - x] && (j - x == 0 || DP[j - x] != 0)) {
				DP[j] = input[i][1] + DP[j - x];
			}
		}
	}

	for (int i = 1; i <= w; ++i) {
		maxNum = max(maxNum, DP[i]);
	}

	cout << maxNum << endl;

	return 0;
}