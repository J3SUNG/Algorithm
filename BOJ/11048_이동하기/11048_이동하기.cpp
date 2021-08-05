#include <iostream>
#include <algorithm>
using namespace std;

int map[1010][1010];

int main(int argc, char *argv[])
{
	int x, y;
	cin >> x >> y;

	for (int i = 0; i < 1010; ++i) {
		for (int j = 0; j < 1010; ++j) {
			map[i][j] = 0;
		}
	}

	for (int i = 1; i <= x; ++i) {
		for (int j = 1; j <= y; ++j) {
			cin >> map[i][j];
			map[i][j] += max(map[i - 1][j - 1], max(map[i - 1][j], map[i][j - 1]));
		}
	}
	cout << map[x][y];

	return 0;
}