#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
	int x, y;
	int z;

	cin >> x >> y;

	z = x % 30;

	if (z * 12 == y)
	{
		cout << "O" << endl;
	}
	else
	{
		cout << "X" << endl;
	}

	return 0;
}