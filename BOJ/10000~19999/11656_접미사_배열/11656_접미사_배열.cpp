#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char* argv[])
{
	string s;
	string temp;
	vector<string> v;

	cin >> s;

	for (int i = 0; i < s.length(); ++i) {
		temp = s.substr(i, s.length() - i);
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); ++i) {
		cout << v[i] << endl;
	}

	return 0;
}