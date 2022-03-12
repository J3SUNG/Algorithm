#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(int money, vector<int> costs) {
    int answer = 0;
    int value[6] = {1, 5, 10, 50, 100, 500};
    bool use[6] = {true, true, true, true, true, true};
    double goodCosts;
    double arr[6] = {1, 5, 10, 50, 100, 500};

    for(int i=0; i<6; ++i){
      arr[i] = costs[i] / arr[i];
    } 
    goodCosts = arr[0];
    for(int i=1; i<6; ++i){
      if(arr[i]>goodCosts){
        use[i] = false;
      } else {
        goodCosts = arr[i];
      }
    }

    for(int i=5; i>=0; --i){
      if(use[i]){
        answer += money / value[i] * costs[i] ;
        money = money % value[i];
      }
    }

    return answer;
}