#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <queue>
#include <stack>
#include <string>
using namespace std;

const int MAX = 2000002;
bool arr[MAX];

int main(int argc, char *argv[])
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	int num;
	memset(arr, false, sizeof(arr));

	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> num;
		arr[num + 1000001] = true;
	}

	for (int i = MAX - 1; i > 0; --i) {
		if (arr[i]) {
			cout << i - 1000001 << "\n";
		}
	}

	return 0;
}