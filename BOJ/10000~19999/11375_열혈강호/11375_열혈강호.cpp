#include <iostream>
#include <vector>
using namespace std;

vector<int> v[1010];
int work[1010];
bool finish[1010];

bool DFS(int x)
{
	for (int i = 0; i < v[x].size(); ++i) {
		int t = v[x][i];

		if (finish[t]) {
			continue;
		}
		finish[t] = true;

		if (work[t] == 0 || DFS(work[t])) {
			work[t] = x;
			return true;
		}
	}
	return false;
}

int main(int argc, char *argv[]) 
{
	int n, m;
	int c;
	int num;
	int count = 0;

	cin >> n >> m;

	for (int i = 1; i <= n; ++i) {
		cin >> c;
		for (int j = 0; j < c; ++j) {
			cin >> num;
			v[i].push_back(num);
		}
	}

	fill(work, work + 1010, 0);
	for (int i = 1; i <= n; ++i) {
		fill(finish, finish + 1010, false);
		if (DFS(i)) {
			++count;
		}
	}

	cout << count << endl;

	return 0;
}