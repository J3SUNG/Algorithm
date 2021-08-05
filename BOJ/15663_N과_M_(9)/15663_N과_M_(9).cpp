#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
int visit[10];
vector<int> arr;
vector<int> v;

void DFS(int x)
{
	int use[10010];
	memset(use, 0, sizeof(use));

	v.push_back(arr[x]);
	if (v.size() == m)
	{
		for (int i = 0; i < v.size(); ++i)
		{
			printf("%d ", v[i]);
		}
		printf("\n");
		v.pop_back();
		return;
	}

	for (int i = 0; i < arr.size(); ++i)
	{
		if (!visit[i] && !use[arr[i]])
		{
			visit[i] = 1;
			use[arr[i]] = 1;
			DFS(i);
			visit[i] = 0;
		}
	}
	v.pop_back();
}

int main(int argc, char *argv[])
{
	scanf("%d", &n);
	scanf("%d", &m);

	arr.resize(n);

	memset(visit, 0, sizeof(visit));

	for (int i = 0; i < n; ++i)
	{
		cin >> arr[i];
	}

	sort(arr.begin(), arr.end());

	for (int i = 0; i < arr.size(); ++i)
	{
		if (i != 0 && arr[i] == arr[i - 1])
		{
			continue;
		}
		visit[i] = 1;
		DFS(i);
		visit[i] = 0;
	}

	return 0;
}