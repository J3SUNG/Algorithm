#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int map[60][60];
int c = 0;

void move(int a, int b, int d)
{
	for (int i = 0; i < 4; ++i)
	{
		int curDir = (d + 7 - i) % 4;
		int curX = b;
		int curY = a;

		switch (curDir)
		{
		case 0:
			curY -= 1;
			break;
		case 1:
			curX += 1;
			break;
		case 2:
			curY += 1;
			break;
		case 3:
			curX -= 1;
			break;
		}
		if (map[curY][curX] == 0)
		{
			map[curY][curX] = 2;
			++c;
			move(curY, curX, curDir);
			return;
		}
	}

	switch (d)
	{
	case 0:
		a += 1;
		break;
	case 1:
		b -= 1;
		break;
	case 2:
		a -= 1;
		break;
	case 3:
		b += 1;
		break;
	}

	if (map[a][b] != 1)
	{
		move(a, b, d);
	}
}

int main(int argc, char *argv[])
{
	int n, m;
	int startX, startY;
	int direction;

	cin >> n >> m;
	cin >> startY >> startX >> direction;

	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < m; ++j)
		{
			cin >> map[i][j];
		}
	}

	map[startY][startX] = 2;
	move(startY, startX, direction);

	cout << c + 1 << endl;

	return 0;
}