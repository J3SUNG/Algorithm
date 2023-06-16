#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
	int n;
	int deadline;
	int score;
	int end;
	int result = 0;
	int arr[1001];
	vector<pair<int, int>> v;

	memset(arr, 0, sizeof(arr));

	cin >> n;

	for (int i = 0; i < n; ++i)
	{
		cin >> deadline >> score;
		v.push_back({score, deadline});
	}

	sort(v.begin(), v.end(), greater<pair<int, int>>());

	for (int i = 0; i < n; ++i)
	{
		end = v[i].second;
		while (end >= 1)
		{
			if (arr[end] == 0)
			{
				arr[end] = v[i].first;
				break;
			}
			else
				--end;
		}
	}

	for (int i = 1; i <= 1000; i++)
	{
		result += arr[i];
	}

	cout << result << endl;

	return 0;
}