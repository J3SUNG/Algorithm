#include <stdio.h>
#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
	int c = 0;
	int x, y;
	scanf("%d", &c);
	for (int i = 0; i < c; i++)
	{
		scanf("%d", &x);
		scanf("%d", &y);
		printf("%d\n", x + y);
	}
	return 0;
}