#include <iostream>
#include <string>
using namespace std;

int main(int argc, char * argv[])
{
	int a;
	int i = 0;
	string s;
	int sum = 0;
	cin >> a;
	cin >> s;
	for (int i = 1; i <= a; i++) {
		sum += stoi(s.substr(s.size() - i, 1)) ;
	}
	cout << sum << endl;
	return 0;
}