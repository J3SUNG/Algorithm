#include <iostream>
#include <cstdlib>
#include <cstring>
#include <algorithm>
#define MAX_VALUE 987654321
using namespace std;

int main(int argc, char *argv[])
{
	int s;
	int num;
	int arr[1001][10];
	
	cin >> s;
	
	memset(arr, MAX_VALUE, sizeof(arr);
	
	for(int i=1; i<1001; ++i) {
		arr[i][1] = i;
	}
	
	num = 2;
	for(int i=2; i<10; ++i){
		for(int j=2; j<1001; ++j){
			if(arr[j][i-1] != MAX_VALUE){
				min(arr[num + 2
			}
		}
		num *= num;
	}
	
	cout << result << endl;
	
	return 0;
}