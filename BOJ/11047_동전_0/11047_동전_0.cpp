#include <iostream>
#include <vector>
using namespace std;

int main(int argc, char * argv[])
{
	int N;
	int K;
	int x;
	int value = 0;
	int count = 0;
	vector<int> v;

	cin >> N;
	cin >> K;

	for (int i = 0; i < N; i++) {
		cin >> x;
		v.push_back(x);
	}
	
	for (int i = N-1; 0 <= i; i--) {
		while(v[i] < K && value + v[i] <= K) {
			value += v[i];
			count++;
		}
	}

	cout << count << endl;

	return 0;
}