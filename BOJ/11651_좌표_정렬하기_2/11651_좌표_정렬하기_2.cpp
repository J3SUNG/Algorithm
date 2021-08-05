#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>
using namespace std;

bool compare(pair<int, int>a, pair<int, int>b) {
	if (a.second == b.second) {
		return a.first < b.first;
	}
	else {
		return a.second < b.second;
	}
}

int main(int argc, char *argv[])
{
	int n;
	int x, y;
	vector<pair<int, int>> v;

	scanf("%d",& n);

	for (int i = 0; i < n; ++i) {
		scanf("%d", &x);
		scanf("%d", &y);

		v.push_back(make_pair(x, y));
	}

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < n; ++i) {
		printf("%d %d\n", v[i].first, v[i].second);
	}

	return 0;
}