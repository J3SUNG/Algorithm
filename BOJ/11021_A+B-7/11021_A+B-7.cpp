#include <iostream>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
	int t;

	cin >> t;

	for(int i = 1; i <= t; ++i){
		int x, y;

		cin >> x >> y;

		cout << "Case #" << i << ": " << x + y << endl;
	}

	return 0;
}