#include <iostream>
#include <cstring>
using namespace std;

int n;
int map[110][110];
int chkMap[110][110];
int visit[110];

void DFS(int a, int b, int num)
{
	visit[b] = 1;
	chkMap[num][b] = 1;

	for (int j = 1; j <= n; ++j) {
		if (map[b][j] == 1 && visit[j] == 0) {
			DFS(b, j, num);
		}
	}
}

int main(int argc, char *argv[])
{
	cin >> n;

	memset(map, 0, sizeof(map));
	memset(chkMap, 0, sizeof(chkMap));

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			cin >> map[i][j];
			chkMap[i][j] = map[i][j];
		}
	}

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			if (map[i][j] != 0) {
				memset(visit, 0, sizeof(visit));
				DFS(i, j, i);
			}
		}
	}

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			cout << chkMap[i][j] << " ";
		}
		cout << endl;
	}

	return 0;
}