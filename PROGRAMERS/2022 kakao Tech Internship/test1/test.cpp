#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<pair<int, int> > v = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};

void calc(char c, int num)
{
    switch(c){
        case 'R':
            v[0].first += num;
            break;
        case 'T':
            v[0].second += num;
            break;
        case 'C':
            v[1].first += num;
            break;
        case 'F':
            v[1].second += num;
            break;
        case 'J':
            v[2].first += num;
            break;   
        case 'M':  
            v[2].second += num;
            break; 
        case 'A':
            v[3].first += num;
            break;
        case 'N':
            v[3].second += num;
            break;
    }
}

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    string type = "RTCFJMAN";

    for(int i=0; i<survey.size(); ++i){
        if(choices[i] < 4) {
            calc(survey[i][0], 4 - choices[i]);
        } else if (choices[i] > 4){
            calc(survey[i][1], choices[i] - 4);
        }
    }

    for(int i=0; i<4; ++i){
        if(v[i].first >= v[i].second){
            answer += type[i * 2];
        } else {
            answer += type[i * 2 + 1];
        }
    }

    for(int i=0; i<4; ++i) {
      cout << v[i].first << " " << v[i].second << endl; 
    }

    return answer;
}