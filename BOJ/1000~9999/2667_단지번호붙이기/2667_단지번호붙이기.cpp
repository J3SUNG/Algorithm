#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int map[30][30];
int group[1000];
int moveX[4] = { 0, 1, 0, -1 };
int moveY[4] = { 1, 0, -1, 0 };

void DFS(int a, int b, int count)
{
	if (map[a][b] == 1) {
		map[a][b] = 0;
		
		for (int i = 0; i < 4; ++i) {
			int x = a + moveX[i];
			int y = b + moveY[i];

			DFS(x, y, count);
		}
		++group[count];
	}
}

int main(int argc, char *argv[])
{
	memset(map, 0, sizeof(map));
	memset(group, 0, sizeof(group));

	int n;
	string inputNum;
	int c = 0;
	int groupCount = 0;

	cin >> n;

	for (int i = 1; i <= n; ++i) {
		cin >> inputNum;
		for (int j = 1; j <= n; ++j) {
			map[i][j] = (inputNum[j - 1] - '0');
		}
	}
	
	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			DFS(i, j, c);
			if (group[c] != 0) {
				++c;
			}
		}
	}

	for (int i = 0; i < 1000; ++i) {
		if (group[i] == 0) {
			groupCount = i;
			break;
		}
	}

	sort(group, group + groupCount);

	cout << groupCount << endl;

	for (int i = 0; i < groupCount; ++i) {
		cout << group[i] << endl;
	}

	return 0;
}