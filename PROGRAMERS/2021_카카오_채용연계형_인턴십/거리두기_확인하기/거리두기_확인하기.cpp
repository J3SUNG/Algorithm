#include <iostream>
#include <cstring>
#include <string>
#include <vector>
#include <queue>
using namespace std;

int result;
vector<vector<char> > v;
vector<vector<bool> > visit;
vector<vector<bool> > falseVisit(5, vector<bool>(5, false));
queue<pair<pair<int, int>, int> > q;

vector<int> solution(vector<vector<string>> places) {
    int y, x, c;
    vector<char> temp;
    vector<int> answer;
    
    for(int i=0; i<places.size(); ++i){
        result = 1;
        v.clear();
        
        for(int j=0; j<5; ++j){
            for(int k=0; k<5; ++k){
                temp.push_back(places[i][j][k]);
            }
            v.push_back(temp);
            temp.clear();
        }
    
        for(int i=0; i<5; ++i){
            for(int j=0; j<5; ++j){
                if(v[i][j] == 'P'){
                    visit = falseVisit;
                    q.push({{i, j}, 0});
                    
                    while(!q.empty()){
                        y = q.front().first.first;
                        x = q.front().first.second;
                        c = q.front().second;
                        q.pop();
                        visit[y][x] =true;
                        if(c != 0 && c < 3 && v[y][x] == 'P'){
                            result = 0;
                            while(!q.empty()){
                                q.pop();
                            }
                        } else if(c == 3){
                            continue;
                        }
                        if(y-1 >= 0 && v[y-1][x] != 'X' && !visit[y-1][x]){
                            q.push({{y-1, x}, c+1});
                        }
                        if(x-1 >= 0  && v[y][x-1] != 'X' && !visit[y][x-1]){
                            q.push({{y, x-1}, c+1});
                        }
                        if(y+1 < 5 && v[y+1][x] != 'X' && !visit[y+1][x]){
                            q.push({{y+1, x}, c+1});
                        }
                        if(x+1 < 5 && v[y][x+1] != 'X' && !visit[y][x+1]){
                            q.push({{y, x+1}, c+1});
                        }
                    }
                }
            }
            if(result == 0){
                break;
            }
            cout << endl;
        }
        answer.push_back(result);
    }
    
    return answer;
}