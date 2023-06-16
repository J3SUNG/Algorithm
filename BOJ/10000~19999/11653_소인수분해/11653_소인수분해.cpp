#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
	int n;

	cin >> n;

	while (1) {
		if (n == 1) {
			break;
		}

		for (int i = 2; i <= n; ++i) {
			if (n % i == 0) {
				cout << i << endl;
				n /= i;
				break;
			}
		}
	}

	return 0;
}