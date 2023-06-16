#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

int main(int argc, char *argv[])
{
	string s;

	while (1) {
		getline(cin, s);
		if (s == "END") {
			break;
		}
		reverse(s.begin(), s.end());
		cout << s << endl;
	}

	return 0;
}