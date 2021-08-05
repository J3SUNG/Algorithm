#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
	int n;
	int num;
	int arr[10010];

	cin >> n;

	memset(arr, 0, sizeof(arr));

	for (int i = 0; i < n; ++i) {
		scanf("%d", &num);
		++arr[num];
	}

	for (int i = 0; i <= 10000; ++i) {
		for (int j = 0; j < arr[i]; ++j) {
			printf("%d\n", i);
		}
	}

	return 0;
}