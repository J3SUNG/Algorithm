#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool asc_sort(int a, int b)
{
	return a > b;	
}

int main(int argc, char *argv[])
{
	int n;
	int num;
	int result = 0;
	bool zero = false;
	vector<int> v;
	
	cin >> n;
	
	for(int i=0; i<n; ++i) {
		cin >> num;
		v.push_back(num);
	}
	
	sort(v.begin(), v.end(), asc_sort);
	
	while(1){
		if(v[0] > 0){
			if(v.size() > 1){
				if(v[1] > 1){
					result += v[0] * v[1]	;
					v.erase(v.begin());
					v.erase(v.begin());
				} else if (v[1] == 1){
					result += v[0] + 1;	
					v.erase(v.begin());
					v.erase(v.begin());
				} else if (v[1] == 0) {
					result += v[0];	
					v.erase(v.begin());
					v.erase(v.begin());
					zero = true;
				} else  {
					result += v[0];	
					v.erase(v.begin());
				}
			} 
			else {
				result += v[0];
				v.erase(v.begin());
			}
		} else if(v[0] == 0){
			v.erase(v.begin());
			zero = true;
		} else {
			sort(v.begin(), v.end());
			if(v.size() > 1){
				result += v[0] * v[1];
				v.erase(v.begin());
				v.erase(v.begin());
			} else {
				if(zero){
					v.erase(v.begin());	
				} else {
					result += v[0];
					v.erase(v.begin());
				}
			}
		}
		if(v.size() == 0){
		  break;
	  }
	}
	
	cout << result << endl;
	
	return 0;
}
