#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
#include <string>
using namespace std;

bool map[110][110];
int pattern[4][2049];
int quo[11] = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};

int change(int num)
{
	switch (num)
	{
	case 0:
		num = 1;
		break;
	case 1:
		num = 2;
		break;
	case 2:
		num = 3;
		break;
	case 3:
		num = 0;
		break;
	}
	return num;
}

void SetPattern()
{
	pattern[0][0] = 0; //우
	pattern[1][0] = 1; //상
	pattern[2][0] = 2; //좌
	pattern[3][0] = 3; //하

	for (int i = 0; i < 4; ++i)
	{
		for (int j = 0; j < 11; ++j)
		{
			for (int k = 0; k < quo[j]; ++k)
			{
				pattern[i][quo[j] + k] = change(pattern[i][quo[j] - k - 1]);
			}
		}
	}
}

void run(int x, int y, int d, int g)
{
	map[y][x] = true;
	for (int i = 0; i < quo[g]; ++i)
	{
		switch (pattern[d][i])
		{
		case 0:
			++x;
			break;
		case 1:
			--y;
			break;
		case 2:
			--x;
			break;
		case 3:
			++y;
			break;
		}
		map[y][x] = true;
	}
}

void find()
{
	int count = 0;

	for (int i = 0; i < 101; ++i)
	{
		for (int j = 0; j < 101; ++j)
		{
			if (map[i][j] & map[i + 1][j] & map[i][j + 1] & map[i + 1][j + 1])
			{
				++count;
			}
		}
	}

	cout << count << endl;
}

int main(int argc, char *argv[])
{
	memset(map, false, sizeof(map));
	SetPattern();

	int n;
	int x, y, d, g;

	cin >> n;

	for (int i = 0; i < n; ++i)
	{
		cin >> x >> y >> d >> g;

		run(x, y, d, g);
	}

	find();

	return 0;
}