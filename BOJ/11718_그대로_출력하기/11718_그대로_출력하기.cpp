#include <iostream>
#include <string>
using namespace std;

int main(int argc, char *argv[])
{
	string s= " ";
	while(s != ""){
		getline(cin, s);
		cout << s << endl;
	}
	return 0;
}