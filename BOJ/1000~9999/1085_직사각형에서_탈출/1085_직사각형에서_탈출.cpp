#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
	int x, y, w, h;
	int minD = 987654321;

	cin >> x;
	cin >> y;
	cin >> w;
	cin >> h;

	minD = min(minD, w - x);
	minD = min(minD, x);
	minD = min(minD, h - y);
	minD = min(minD, y);

	cout << minD << endl;

	return 0;
}