#include <iostream>
#include <vector>
#include <cmath>
#include <string>
#include <algorithm>
using namespace std;

int main (int argc, char *argv[])
{
	int n;
	int score = 9;
	int index;
	int result = 0;
	vector<int> alp(26);
	vector<string> v;
	string str;
	string text[10];
	
	cin >> n;
	
	for(int i=0; i<n; ++i){
		cin >> str;
		v.push_back(str);
	}
	
	for(int i=0; i<n; ++i){
		for(int j=0; j<v[i].length(); ++j){
			index = v[i][j] - 'A';
			alp[index] += pow(10, v[i].length() - j - 1);
		}
	}
	
	sort(alp.begin(), alp.end(), greater<int>());
	
	for(int i=0; i<10; ++i){
		result += alp[i] * (9 - i);
	}
	
	cout << result << endl;
	
	return 0;
}