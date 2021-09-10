#include <iostream>
#include <algorithm>
#include <cstring>
#include <string>
#include <vector>
using namespace std;

int convert(int time, int num, string type)
{
    cout << time << " " << num << " " << type << endl;
    if(type == "plus"){
        if((time % 100) + num >= 60){
            time += 100;
            time += (((time % 100) + num) % 60) - (time % 100);
        } else{
            time += num;
        }
    } else if(type == "minus"){
        if((time % 100) - num < 0){
            time -= 100;
            time += (60 - (time % 100) - num) - (time % 100);
        } else{
            time -= num;
        }
    }   
    cout << time << endl;
    return time;
}

string solution(int n, int t, int m, vector<string> timetable) {
    int one;
    int ten;
    int time = 900;
    int index = -1;
    int prevTime;
    int prevPossible;
    string strPrevTime;
    string answer = "";
    vector<int> tt;
    
    for(int i=0; i<timetable.size(); ++i){
        one = stoi(timetable[i].substr(3, 2));
        ten = stoi(timetable[i].substr(0, 2));
        tt.push_back((ten * 100) + one);
    }
    sort(tt.begin(), tt.end());
        
    for(int i=0; i<n; ++i){
        prevPossible = false;
        for(int j=0; j<m; ++j){
            ++index;
            cout << time << " " << tt[index] << " " << index << " " << tt.size() << endl;
            if(time < tt[index] || index == tt.size()){
                --index;
                prevPossible = true;
                break;
            }
            cout << time << " " << tt[index] << "@@"<< endl;
        }
        if(prevPossible){
            prevTime = time;
        } else {
            prevTime = convert(tt[index], 1, "minus");
        }
        cout << prevTime << "!!"<< endl;
        time = convert(time, t, "plus");
    }
    
    strPrevTime = to_string(prevTime);
    if(strPrevTime.length() == 1){
        answer += "00:0";
        answer += strPrevTime[0];
    }
    else if(strPrevTime.length() == 2){
        answer += "00:";
        answer += strPrevTime[0];
        answer += strPrevTime[1];
    }
    else if(strPrevTime.length() == 3){
        answer += "0";
        answer += strPrevTime[0];
        answer += ":";
        answer += strPrevTime[1];
        answer += strPrevTime[2];
    } else{
        answer += strPrevTime[0];
        answer += strPrevTime[1];
        answer += ":";
        answer += strPrevTime[2];
        answer += strPrevTime[3];
    }
    
    return answer;
}