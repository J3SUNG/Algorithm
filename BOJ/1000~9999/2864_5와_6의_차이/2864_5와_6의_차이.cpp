#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char* argv[])
{
	int temp;
	string s1;
	string s2;
	string sMin;
	string sMax;

	cin >> s1;
	cin >> s2;

	string s1Min = s1;
	string s1Max = s1;
	string s2Min = s2;
	string s2Max = s2;

	for (int i = 0; i < s1.length(); ++i) {
		if (s1[i]- '0' == 5) {
			s1Max[i] = '6';
		}
		if (s1[i] - '0' == 6) {
			s1Min[i] = '5';
		}
		if (s2[i] - '0' == 5) {
			s2Max[i] = '6';
		}
		if (s2[i] - '0' == 6) {
			s2Min[i] = '5';
		}
	}
	
	temp = stoi(s1Min) + stoi(s2Min);
	sMin = to_string(temp);
	temp = stoi(s1Max) + stoi(s2Max);
	sMax = to_string(temp);

	cout << sMin << " ";
	cout << sMax << endl;

	return 0;
}