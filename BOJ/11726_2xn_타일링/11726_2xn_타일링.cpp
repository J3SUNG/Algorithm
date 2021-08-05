#include <iostream>
using namespace std;

int memo[1001];
int x;

void func(int num)
{
	if (num <= x) {
		memo[num] = memo[num - 2] + memo[num - 1];
		memo[num] %= 10007;
		func(++num);
	}
	return;
}

int main(int argc, char *argv[])
{
	memo[0] = 1;
	memo[1] = 1;
	memo[2] = 2;
	cin >> x;
	func(3);
	
	memo[x] %= 10007;
	cout << memo[x];
	return 0;
}