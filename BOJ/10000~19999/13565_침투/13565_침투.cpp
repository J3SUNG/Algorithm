#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

bool flag = false;
int n, m;
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};
int map[1010][1010];
int visit[1010][1010];
string s;

void DFS(int a, int b)
{
	visit[a][b] = 1;

	if (flag == true || a == n - 1)
	{
		flag = true;
		return;
	}

	for (int i = 0; i < 4; ++i)
	{
		int x = moveX[i] + a;
		int y = moveY[i] + b;

		if (visit[x][y] == 0 && map[x][y] == 0)
		{
			DFS(x, y);
		}
	}
}

int main(int argc, char *argv[])
{
	cin >> n >> m;

	memset(map, -1, sizeof(map));
	memset(visit, 0, sizeof(visit));

	for (int i = 1; i <= n; ++i)
	{
		cin >> s;
		for (int j = 1; j <= m; ++j)
		{
			map[i][j] = s[j - 1] - '0';
		}
	}

	for (int j = 1; j <= m; ++j)
	{
		if (map[1][j] == 0 && visit[1][j] == 0)
		{
			DFS(1, j);
		}
	}

	flag == true ? cout << "YES" << endl : cout << "NO" << endl;

	return 0;
}