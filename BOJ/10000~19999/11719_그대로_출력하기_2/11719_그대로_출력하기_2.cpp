#include <iostream>
#include <string>
using namespace std;

int main(int argc, char * argv[])
{
	string s;
	for(int i=0; i<100; ++i){
		getline(cin, s);
		cout << s << endl;
	}

	return 0;
}