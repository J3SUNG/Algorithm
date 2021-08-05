#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

typedef long long ll;
vector<ll> v;

int main(int argc, char* argv[])
{
	ll n;
	ll num;
	ll a;
	ll b;
	ll count = 0;
	ll temp = 0;

	scanf("%lld", &n);

	for (int i = 0; i < n; ++i) {
		scanf("%lld", &num);
		v.push_back(num);
	}

	scanf("%lld", &a);
	scanf("%lld", &b);

	for (int i = 0; i < v.size(); ++i) {
		temp = v[i] - a;
		if (temp < 1) {
			++count;
		}
		else {
			count += (temp - 1) / b + 2;
		}
	}

	printf("%lld\n", count);

	return 0;
}