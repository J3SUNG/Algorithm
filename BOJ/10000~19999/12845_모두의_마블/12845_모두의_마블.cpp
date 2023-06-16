#include <iostream>
#include <cstring>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, char* argv[])
{
	int n;
	int a, b;
	int right, left;
	int higherLevel = 0;
	int index = 0;
	int score = 0;
	vector<int> v;

	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> a;

		v.push_back(a);

		if (higherLevel < a) {
			higherLevel = a;
			index = i;
		}
	}

	while (1) {
		right = index + 1;
		left = index - 1;

		if (right >= n && left < 0) {
			break;
		}
		else if (right >= n) {
			score += v[index] + v[left];
			v.erase(v.begin() + left);
			--index;
			--n;
		}
		else if (left < 0) {
			score += v[index] + v[right];
			v.erase(v.begin() + right);
			--n;
		}
		else {
			if (v[left] > v[right]) {
				score += v[index] + v[left];
				v.erase(v.begin() + left);
				--index;
				--n;
			}
			else {
				score += v[index] + v[right];
				v.erase(v.begin() + right);
				--n;
			}
		}
	}
	
	cout << score << endl;

	return 0;
}