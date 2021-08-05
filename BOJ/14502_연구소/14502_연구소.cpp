#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int n, m;
int safeCount = 0;
int vNum = 0;
int tempMap[10][10];
int map[10][10];
int virus[100][2];
int moveX[4] = {0, 1, 0, -1};
int moveY[4] = {1, 0, -1, 0};

void init()
{
	for (int i = 0; i < 10; ++i)
	{
		for (int j = 0; j < 10; ++j)
		{
			map[i][j] = -1;
			tempMap[i][j] = -1;
		}
	}
}

void mapCopy(int paste[][10], int copy[][10])
{
	for (int i = 0; i < 10; ++i)
	{
		for (int j = 0; j < 10; ++j)
		{
			paste[i][j] = copy[i][j];
		}
	}
}

void counting()
{
	int c = 0;

	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= m; ++j)
		{
			if (map[i][j] == 0)
			{
				++c;
			}
		}
	}

	safeCount = max(safeCount, c);
}

void virusCount()
{
	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= m; ++j)
		{
			cin >> map[i][j];
			tempMap[i][j] = map[i][j];
			if (map[i][j] == 2)
			{
				virus[vNum][0] = i;
				virus[vNum][1] = j;
				++vNum;
			}
		}
	}
}

void infection(int a, int b)
{
	map[a][b] = 2;

	for (int i = 0; i < 4; ++i)
	{
		int x = a + moveX[i];
		int y = b + moveY[i];
		if (map[x][y] == 0)
		{
			infection(x, y);
		}
	}

	if (safeCount == 32)
	{
		cout << endl;
		for (int i = 1; i <= n; ++i)
		{
			for (int j = 1; j <= m; ++j)
			{
				cout << map[i][j] << " ";
			}
			cout << endl;
		}
		cout << endl;
	}
}

void wall(int c)
{
	if (c == 3)
	{
		mapCopy(tempMap, map);
		for (int i = 0; i < vNum; ++i)
		{
			infection(virus[i][0], virus[i][1]);
		}
		counting();
		mapCopy(map, tempMap);
		return;
	}

	for (int i = 1; i <= n; ++i)
	{
		for (int j = 1; j <= m; ++j)
		{
			if (map[i][j] == 0)
			{
				map[i][j] = 1;
				wall(c + 1);
				map[i][j] = 0;
			}
		}
	}
}

int main(int argc, char *argv[])
{
	cin >> n >> m;

	memset(map, 0, sizeof(map));
	memset(tempMap, 0, sizeof(tempMap));
	memset(virus, 0, sizeof(virus));

	init();
	virusCount();
	wall(0);

	cout << safeCount << endl;

	return 0;
}