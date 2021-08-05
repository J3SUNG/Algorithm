#include <iostream>
#include <string>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
{
	int count = 0;
	string s;

	for (int i = 0; i < 8; ++i)
	{
		cin >> s;

		for (int j = 0; j < 8; ++j)
		{
			if ((i + j) % 2 == 0 && s[j] == 'F')
			{
				++count;
			}
		}
	}

	cout << count << endl;

	return 0;
}