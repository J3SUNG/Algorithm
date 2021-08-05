#include <iostream>
using namespace std;

int main(int argc, char* argv[])
{
	int a[5];
	int sum = 0;
	
	for (int i = 0; i < 5; ++i) {
		cin >> a[i];
		sum += a[i];
	}

	cout << sum << endl;

	return 0;
}