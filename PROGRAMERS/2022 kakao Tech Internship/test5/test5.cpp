#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<vector<int>> solution(vector<vector<int>> rc, vector<string> operations){
    vector<vector<int>> answer(rc.size(), vector<int>(rc[0].size()));

    for(int i=0; i<operations.size(); ++i){
        if(operations[i] == "ShiftRow"){
            for(int j=0; j<rc.size(); ++j){
                for(int k=0; k<rc[0].size(); ++k){
                    if(j+1==rc.size()){
                        answer[0][k] = rc[j][k];
                    } else {
                        answer[j+1][k] = rc[j][k];
                    }
                }
            }
        } else {
            for(int j=0; j<rc.size(); ++j){
                for(int k=0; k<rc[0].size(); ++k){
                    if(j==0 && k==0){
                        answer[j][k+1] = rc[j][k];
                    }
                    else if(k==0){
                        answer[j-1][k] = rc[j][k];
                    }
                    else if(j+1==rc.size()){
                        answer[j][k-1] = rc[j][k];
                    }
                    else if(k+1==rc[0].size()){
                        answer[j+1][k] = rc[j][k];
                    }
                    else if(j==0){
                        answer[j][k+1] = rc[j][k];
                    }
                    else {
                        answer[j][k] = rc[j][k];
                    }
                }
            }
        }
        copy(answer.begin(), answer.end(), rc.begin());
    }
    return answer;
}