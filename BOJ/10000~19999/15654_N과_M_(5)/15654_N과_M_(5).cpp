#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
int arr[10];
vector<int> v;

void DFS(int x)
{
	v.push_back(x);

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

	for (int i = 1; i <= n; ++i)
	{
		if (find(v.begin(), v.end(), arr[i]) != v.end())
		{
			continue;
		}
		DFS(arr[i]);
	}
	v.pop_back();
}

int main(int argc, char *argv[])
{
	scanf("%d", &n);
	scanf("%d", &m);

	for (int i = 1; i <= n; ++i)
	{
		cin >> arr[i];
	}

	sort(arr + 1, arr + n + 1);

	for (int i = 1; i <= n; ++i)
	{
		DFS(arr[i]);
	}

	return 0;
}