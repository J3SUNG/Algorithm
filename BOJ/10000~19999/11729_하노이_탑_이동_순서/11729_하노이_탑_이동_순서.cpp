#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
using namespace std;

void hanoiMove(int n, int from, int by, int to)
{
	if (n == 1) {
		printf("%d %d\n",from, to);
	}
	else {
		hanoiMove(n - 1, from, to, by);
		printf("%d %d\n", from, to);
		hanoiMove(n - 1, by, from, to);
	}
}

void hanoiNum(int x)
{
	int num = 1;
	while (--x) {
		num = num * 2 + 1;
	}
	printf("%d\n", num);
}

int main(int argc, char *argv[])
{	
	int x;

	scanf("%d", &x);

	hanoiNum(x);
	hanoiMove(x, 1, 2, 3);

	return 0;
}