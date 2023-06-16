#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
	int N, K;
	int num = 1;
	int div = 1;

	cin >> N;
	cin >> K;

	for (int i = 0; i < K; ++i) {
		num *= N - i;
		div *= K - i;
	}

	cout << num / div << endl;

	return 0;
}