#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int n, m;
vector<int> arr;
vector<int> v;

void DFS(int x)
{
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
		DFS(i);
	}
	v.pop_back();
}

int main(int argc, char *argv[])
{
	scanf("%d", &n);
	scanf("%d", &m);

	arr.resize(n);

	for (int i = 0; i < n; ++i)
	{
		cin >> arr[i];
	}

	sort(arr.begin(), arr.end());
	arr.erase(unique(arr.begin(), arr.end()), arr.end());

	for (int i = 0; i < arr.size(); ++i)
	{
		DFS(i);
	}

	return 0;
}