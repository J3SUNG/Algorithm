#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;

int n;
int num;
int maxNum = -987654321;
int minNum = 987654321;
int ope[4];
vector<int> v;

void solve(int i, int result, int sum, int sub, int mul, int div)
{
	if (i == n)
	{
		maxNum = max(maxNum, result);
		minNum = min(minNum, result);
		return;
	}

	int x = result;
	int y = v[i];
	int z;

	if (sum != 0)
	{
		z = x + y;
		solve(i + 1, z, sum - 1, sub, mul, div);
	}
	if (sub != 0)
	{
		z = x - y;
		solve(i + 1, z, sum, sub - 1, mul, div);
	}
	if (mul != 0)
	{
		z = x * y;
		solve(i + 1, z, sum, sub, mul - 1, div);
	}
	if (div != 0)
	{
		z = x / y;
		solve(i + 1, z, sum, sub, mul, div - 1);
	}
}

int main(int argc, char *argv[])
{
	scanf("%d", &n);

	for (int i = 0; i < n; ++i)
	{
		scanf("%d", &num);
		v.push_back(num);
	}

	for (int i = 0; i < 4; ++i)
	{
		scanf("%d", &ope[i]);
	}

	solve(1, v[0], ope[0], ope[1], ope[2], ope[3]);

	printf("%d\n", maxNum);
	printf("%d\n", minNum);

	return 0;
}