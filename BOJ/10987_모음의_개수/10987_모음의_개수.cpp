#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char* argv[])
{
	int count = 0;
	string s;
	
	cin >> s;

	for (int i = 0; i < s.length(); ++i) {
		if (s[i] == 'a' || s[i] == 'e' || s[i] == 'o' || s[i] == 'u' || s[i] == 'i') {
			++count;
		}
	}

	cout << count << endl;

	return 0;
}