#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

const int MAX = 510;
int N, M;
int map[MAX][MAX];
int visit[MAX][MAX];
int result = 0;

void check(int num)
{
	result = max(result, num);
}

void shape(int a, int b)
{
	int sum = 0;
	if (a + 1 <= N && b + 1 <= M)
	{
		for (int i = 0; i < 2; ++i)
		{
			for (int j = 0; j < 2; ++j)
			{
				sum += map[a + i][b + j];
			}
		}
		check(sum);
	}

	sum = 0;
	if (a + 3 <= N)
	{
		for (int i = 0; i < 4; ++i)
		{
			sum += map[a + i][b];
		}
		check(sum);
	}

	sum = 0;
	if (b + 3 <= M)
	{
		for (int i = 0; i < 4; ++i)
		{
			sum += map[a][b + i];
		}
		check(sum);
	}

	sum = 0;
	if (a + 2 <= N)
	{
		for (int i = 0; i < 3; ++i)
		{
			sum += map[a + i][b];
		}
		if (b - 1 > 0)
		{
			check(sum + map[a][b - 1]);
			check(sum + map[a + 1][b - 1]);
			check(sum + map[a + 2][b - 1]);
		}
		if (b + 1 <= M)
		{
			check(sum + map[a][b + 1]);
			check(sum + map[a + 1][b + 1]);
			check(sum + map[a + 2][b + 1]);
		}
	}

	sum = 0;
	if (b + 2 <= M)
	{
		for (int i = 0; i < 3; ++i)
		{
			sum += map[a][b + i];
		}
		if (a - 1 > 0)
		{
			check(sum + map[a - 1][b]);
			check(sum + map[a - 1][b + 1]);
			check(sum + map[a - 1][b + 2]);
		}
		if (a + 1 <= N)
		{
			check(sum + map[a + 1][b]);
			check(sum + map[a + 1][b + 1]);
			check(sum + map[a + 1][b + 2]);
		}
	}

	sum = 0;
	if (a + 2 <= N && b + 1 <= M)
	{
		sum = map[a][b] + map[a + 1][b] + map[a + 1][b + 1] + map[a + 2][b + 1];
		check(sum);
		sum = map[a][b + 1] + map[a + 1][b + 1] + map[a + 1][b] + map[a + 2][b];
		check(sum);
	}
	if (a + 1 <= N && b + 2 <= M)
	{
		sum = map[a][b] + map[a][b + 1] + map[a + 1][b + 1] + map[a + 1][b + 2];
		check(sum);
		sum = map[a + 1][b] + map[a + 1][b + 1] + map[a][b + 1] + map[a][b + 2];
		check(sum);
	}
}

int main(int argc, char *argv[])
{
	cin >> N >> M;

	memset(map, -1, sizeof(map));
	memset(visit, -1, sizeof(visit));

	for (int i = 1; i <= N; ++i)
	{
		for (int j = 1; j <= M; ++j)
		{
			cin >> map[i][j];
		}
	}

	for (int i = 1; i <= N; ++i)
	{
		for (int j = 1; j <= M; ++j)
		{
			shape(i, j);
		}
	}

	cout << result << endl;

	return 0;
}