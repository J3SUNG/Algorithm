#include <iostream>
using namespace std;

int map[1010][1010];

int main(int argc, char *argv[])
{
	int N, K;
	cin >> N >> K;

	for (int i = 0; i < 1010; ++i) {
		for (int j = 0; j < 1010; ++j) {
			map[i][j] = 0;
		}
	}
	map[1][1] = 1;
	
	for (int i = 2; i <= N + 1; ++i) {
		for (int j = 1; j <= N + 1; ++j) {
			map[i][j] = (map[i - 1][j] + map[i - 1][j - 1]) % 10007;
		}
	}

	cout << map[N + 1][K + 1] << endl;
	return 0;
}