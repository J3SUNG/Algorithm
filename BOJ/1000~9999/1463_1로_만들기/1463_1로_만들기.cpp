#include <iostream>
using namespace std;

int memo[1000000];
int num;
#define MAX 987654321;

void func(int x)
{
	int a = MAX;
	int b = MAX;
	int c = MAX;

	if (x > num)
	{
		return;
	}
	if (x % 3 == 0)
	{
		a = memo[x / 3];
	}
	if (x % 2 == 0)
	{
		b = memo[x / 2];
	}
	c = memo[x - 1];

	if (a <= b && a <= c)
	{
		memo[x] = memo[x / 3] + 1;
	}
	else if (b <= c)
	{
		memo[x] = memo[x / 2] + 1;
	}
	else
	{
		memo[x] = memo[x - 1] + 1;
	}

	func(++x);
}

int main(int argc, char *argv[])
{
	cin >> num;
	memo[0] = 0;
	memo[1] = 0;
	memo[2] = 1;
	memo[3] = 1;

	func(4);
	cout << memo[num];
	return 0;
}