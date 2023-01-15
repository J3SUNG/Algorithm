#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<string> substring(string s) {
    vector<string> v;
    string str = "";
    for(int i=0; i<s.length(); ++i){
        if(s[i] == ' '){
            v.push_back(str);
            str = "";
        } else{
            str += s[i];
        }
    }
    v.push_back(str);

    return v;
}

vector<string> solution(vector<string> arr, vector<string> processes) {
    int time = 1;
    int useTime = 0;
    int noTime = 0;
    bool check = false;
    string temp = "";
    vector<string> v;
    vector<string> answer;
    vector<vector<string>> read;
    vector<vector<string>> write;

    for(int i=0; i<processes.size(); ++i){
        v.clear();
        v = substring(processes[i]);
        if(v[0] == "read"){
            read.push_back(v);
        } else {
            write.push_back(v);
        }
    }

    while(read.size() > 0 || write.size() > 0){
        if(useTime == time){
            check = false;
        }
        if(!check) { 
            if(write.size() > 0 && stoi(write[0][1]) <= time){
                check = true;
                if(useTime <= time){
                    useTime = time + stoi(write[0][2]);
                    for(int i=stoi(write[0][3]); i<=stoi(write[0][4]); ++i){
                        arr[i] = write[0][5];
                    }
                    write.erase(write.begin());
                }
            } else if(read.size() > 0 && stoi(read[0][1]) <= time){
                while(read.size() > 0 && stoi(read[0][1]) <= time){
                    useTime = max(useTime, time + stoi(read[0][2]));
                    for(int i=stoi(read[0][3]); i<=stoi(read[0][4]); ++i){
                        temp += arr[i];
                    }
                    answer.push_back(temp);
                    temp = "";
                    read.erase(read.begin());
                }
            }     
        } 
        if(useTime <= time){
            ++noTime;
        }

        ++time;
    }

    answer.push_back(to_string(useTime - 1 - noTime));

    return answer;
}