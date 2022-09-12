// 40/50 CPU 처리문제

#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
using namespace std;

struct compare {
bool operator()(pair<int, int> a, pair<int, int> b)
    {
        if(a.first == b.first){
            return a.second > b.second;
        }
        return a.first > b.first;
    }
};

int solution(int n, vector<int> cores) {
    int answer = 0;
    pair<int, int> p;
    int coreSize = cores.size();
    priority_queue<pair<int, int>, vector<pair<int, int> >, compare> pq;
    
    for(int i=0; i<coreSize; ++i){
        pq.push({0, i});
    }
    
    for(int i=0; i<n; ++i){
        p = pq.top();
        pq.pop();
        p.first += cores[p.second];
        pq.push(p);
        
        if(i+1 == n){
            answer = p.second + 1;
            break;
        }
    }
    
    return answer;
}