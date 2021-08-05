#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char* argv[])
{
	int n;

	cin >> n;

	for (int i = 1; i <= n - 1; ++i) {
		cout << " ";
	}
	cout << "*\n";
	for (int i = 2; i <= n; ++i) {
		for (int j = 1; j <= n - i; ++j) {
			cout << " ";
		}
		cout << "*";
		for (int j = 1; j <= (i - 1) * 2 - 1; ++j) {
			cout << " ";
		}
		cout << "*";
		cout << "\n";
	}

	return 0;
}