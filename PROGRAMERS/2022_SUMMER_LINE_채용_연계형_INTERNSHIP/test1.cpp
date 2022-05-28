#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> logs) {
    vector<string> answer;
    vector<string> user;
    vector<pair<string, int>> v;
    string u;
    string t;
    double sucUser;
    bool comAdd = false;

    sort(logs.begin(), logs.end());
    logs.erase(unique(logs.begin(), logs.end()),logs.end());

    for(int i=0; i<logs.size(); ++i){
        for(int j=0; j<logs[i].length(); ++j){
            if(logs[i][j] == ' '){
                u = logs[i].substr(0, j);
                t = logs[i].substr(j+1);
            }
        }  
        user.push_back(u);
        for(int j=0; j<v.size(); ++j){
            if(v[j].first == t){
                ++v[j].second;
                comAdd = true;
                break;
            }
        }
        if(!comAdd){
            v.push_back({t, 1});
        }
        comAdd = false;
    }

    sort(user.begin(), user.end());
    user.erase(unique(user.begin(), user.end()),user.end());
    sucUser = user.size();
    sort(v.begin(), v.end());
    for(int i=0; i<v.size(); ++i){
        if(v[i].second >= sucUser/2){
            answer.push_back(v[i].first);
        }
    }
    return answer;
}