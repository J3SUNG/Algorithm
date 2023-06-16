#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int n;
vector<int> check;

int solve(int x)
{
	check.push_back(x);
	int result = 0;

	while (x != 0)
	{
		result += pow(x % 10, 2);
		x /= 10;
	}

	if (result == 1)
	{
		return 1;
	}

	if (find(check.begin(), check.end(), result) != check.end())
	{
		return 0;
	}

	return solve(result);
}

int main(int argc, char *argv[])
{
	cin >> n;

	solve(n) == 1 ? cout << "HAPPY" << endl : cout << "UNHAPPY" << endl;

	return 0;
}