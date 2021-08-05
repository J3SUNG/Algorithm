#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char* argv[])
{
	string s;

	cin >> s;

	for (int i = 0; i < s.length() / 2; ++i) {
		if (s[i] != s[s.length() - i - 1]) {
			cout << "0" << endl;
			return 0;
		}
	}

	cout << "1" << endl;
	return 0;
}