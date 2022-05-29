#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>
using namespace std;

int solution(int n, vector<int> times) {
    int answer = 0;
    int DP[2001];
    
    for(int i=0; i<=2000; ++i){
        DP[i] = 987654321;
    }

    DP[0] = 0;
    for(int i=1; i<n; ++i){
        for(int j=0; j<times.size(); ++j){
            if(i-(j+1) >= 0 && i-(j+1)>=j){
                DP[i] = min(DP[i], DP[i-(j+1)] + times[j]);
            }
        }
    }

    answer = DP[n-1];

    return answer;
}