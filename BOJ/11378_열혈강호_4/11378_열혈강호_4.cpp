#include <iostream>
#include <vector>
using namespace std;

vector<int> v[1010];
int work[1010];
bool visit[1010];

bool DFS(int x)
{
	for (int i = 0; i < v[x].size(); ++i) {
		int t = v[x][i];

		if (visit[t]) {
			continue;
		}
		visit[t] = true;

		if (work[t] == 0 || DFS(work[t])) {
			work[t] = x;
			return true;
		}
	}
	return false;
}

int main(int argc, char *argv[]) 
{
	bool flag = true;
	int n, m, k;
	int c;
	int num;
	int count = 0;

	scanf("%d", &n);
	scanf("%d", &m);
	scanf("%d", &k);

	for (int i = 1; i <= n; ++i) {
		scanf("%d", &c);
		for (int j = 0; j < c; ++j) {
			scanf("%d", &num);
			v[i].push_back(num);
		}
	}

	fill(work, work + 1010, 0);
	for (int i = 1; i <= n; ++i) {
		fill(visit, visit + 1010, false);
		if (DFS(i)) {
			++count;
		}
	}

	while (k > 0 && flag) {
		for (int i = 1; i <= n; ++i) {
			fill(visit, visit + 1010, false);
			if (DFS(i)) {
				flag = true;
				++count;
				--k;
				break;
			}
			else {
				flag = false;
			}
		}
	}

	printf("%d\n", count);

	return 0;
}