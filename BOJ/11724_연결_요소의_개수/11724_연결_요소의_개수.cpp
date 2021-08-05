#include <iostream>
#include <cstring>
using namespace std;

int n, m;
int countNum;
int map[1010][1010];
int visit[110];

void DFS(int a, int b)
{
	visit[b] = 1;

	for (int j = 1; j <= n; ++j) {
		if (map[b][j] == 1 && visit[j] == 0) {
			DFS(b, j);
		}
	}
}

int main(int argc, char *argv[])
{
	countNum = 0;

	cin >> n;
	cin >> m;

	memset(map, 0, sizeof(map));
	memset(visit, 0, sizeof(visit));

	for (int i = 1; i <= m; ++i) {
		int a, b;
		cin >> a;
		cin >> b;
		map[a][b] = 1;
		map[b][a] = 1;
	}

	for (int i = 1; i <= n; ++i) {
		if (visit[i] == 0) {
			DFS(0, i);
			++countNum;
		}
	}

	for (int i = 1; i <= n; ++i) {
		if (visit[i] == 0) {
			++countNum;
		}
	}

	cout << countNum << endl;

	return 0;
}