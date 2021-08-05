#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
	int x, y;
	int div;
	int i = 0;
	string s;
	string temp;

	cin >> s;

	while (1)
	{
		if (s[i] == ':')
		{
			temp = s.substr(0, i);
			x = stoi(temp);

			temp = s.substr(i + 1, s.length());
			y = stoi(temp);
			break;
		}
		++i;
	}

	div = min(x, y);

	while (x % div != 0 || y % div != 0)
	{
		--div;
	}

	cout << x / div << ":" << y / div << endl;

	return 0;
}