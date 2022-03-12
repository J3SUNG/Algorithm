#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(int n, bool clockwise) {
    int value;
    int num = 0;
    int cycle;
    int x, y;
    int count = 0;
    int endPoint = 0;
    vector<pair<int, int>> pos = {{0,0}, {0,n-1}, {n-1,0}, {n-1,n-1}};
    vector<vector<int>> answer(n, vector<int>(n));
    answer[0][0] = 1;
    answer[0][n-1] = 1;
    answer[n-1][0] = 1;
    answer[n-1][n-1] = 1;

    if(clockwise){
        cycle = 1;
    } else {
        cycle = 2;
    }

    while(cycle){ // x+ y+ x- y-
        if(endPoint == 4){
            break;
        }
        if(cycle==1){
            ++pos[num].first;
        }
        if(cycle==2){
            ++pos[num].second;
        }
        if(cycle==3){
            --pos[num].first;
        }
        if(cycle==4){
            --pos[num].second;
        }
        x = pos[num].first;
        y = pos[num].second;
        value = answer[x][y];

        if(answer[x][y] == 0){
            ++value;
            answer[x][y] = value;
            endPoint = 0;
        } else {
            if(clockwise){
                ++cycle;
                if(cycle == 5){
                    cycle = 1;
                }
            } else {
                --cycle;
                if(cycle == 0){
                    cycle = 4;
                }
            }
            ++count;
            if(count == 4){
                if(clockwise){
                    ++cycle;
                    if(cycle == 5){
                        cycle = 1;
                    }
                } else {
                    --cycle;
                    if(cycle == 0){
                        cycle = 4;
                    }
                }
                count = 0;   
            }
            ++endPoint;
        }
    }

    return answer;
}