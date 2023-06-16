#include <iostream>
#include <string>
using namespace std;

int main(int argc, char * argv[])
{
	string s;
	cin >> s;
	int ten = s.size() / 10;
	int won = s.size() % 10;
	for (int i = 1; i <= ten; i++) {
		cout << s.substr(10 * (i - 1), 10) << "\n";
	}
	if (won != 0) {
		cout << s.substr(ten * 10, won) << "\n";
	}
	return 0;
}