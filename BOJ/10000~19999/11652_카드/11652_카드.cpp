#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int main(int argc, char* argv[])
{
	int n;
	long long x;
	long long num;
	int count = 0;
	long long manyNum;
	int manyNumCount = 0;
	vector<long long> v;

	scanf("%d", &n);

	for (int i = 0; i < n; ++i) {
		scanf("%lld", &x);
		v.push_back(x);
	}
	
	sort(v.begin(), v.end());

	num = v[0];
	manyNum = v[0];
	for (int i = 1; i < n; ++i) {
		if (num == v[i]) {
			++count;
		}
		else {
			num = v[i];
			count = 0;
		}

		if (count > manyNumCount) {
			manyNumCount = count;
			manyNum = num;
		}
	}

	printf("%lld\n", manyNum);

	return 0;
}