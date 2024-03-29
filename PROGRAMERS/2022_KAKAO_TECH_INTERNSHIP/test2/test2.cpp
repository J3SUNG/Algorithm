#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    int answer = 0;
    long long sum1 = 0;
    long long sum2 = 0;
    long end = queue1.size()*3;
    queue<int> q1;
    queue<int> q2;
    for(int i=0; i<queue1.size(); ++i){
        sum1 += queue1[i];
        sum2 += queue2[i];
        q1.push(queue1[i]);
        q2.push(queue2[i]);
    }
    while(sum1 != sum2){
        ++answer;
        if(sum1 < sum2){
            sum1 += q2.front();
            q1.push(q2.front());
            sum2 -= q2.front();
            q2.pop();
        } else {
            sum2 += q1.front();
            q2.push(q1.front());
            sum1 -= q1.front();
            q1.pop();
        }
        if(answer > end){
            return -1;
        }
    }

    return answer;
}
