#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>
using namespace std;

int main(int argc, char *argv[])
{
	int n;
	int num = 0;
	int total = 0;
	vector<int> v;
	
	cin >> n;

	for (int i = 0; i < n; ++i) {
		int x;

		cin >> x;

		v.push_back(x);
	}
	
	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); ++i) {
		num += v[i];
		total += num;
	}

	cout << total << endl;

	return 0;
}