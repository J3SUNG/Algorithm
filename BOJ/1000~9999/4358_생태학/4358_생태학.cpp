#include <iostream>
#include <map>
#include <algorithm>
#include <string>
#include <vector>
#include <cmath>
using namespace std;

int main (int argc, char *argv[])
{
	int n;
	int personnel;
  char s[31];
	vector<string> v;
	map<string, int> m;
	
	while(1){
		cin.getline(s, 31, '\n');
		
		if(cin.eof() == true) {
      break;
    }
		if(m.count(s) == 0 ){
			v.push_back(s);
			m.insert(make_pair(s, 1));
		} else {
			++m[s];	
		}
		++personnel;
	}
	
	sort(v.begin(), v.end());
		
	cout << fixed;
	cout.precision(4);
	
	for(int i=0; i<v.size(); ++i){
  	cout << v[i] << " ";
    cout << (double)m[v[i]] / (double)personnel * 100 << endl;
	}
	
	return 0;
}
