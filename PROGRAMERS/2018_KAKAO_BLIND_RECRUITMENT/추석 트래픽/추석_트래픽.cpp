#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> split(string str, char Delimiter) {
    istringstream iss(str);             
    string buffer;                      
 
    vector<string> result;
 
    while (getline(iss, buffer, Delimiter)) {
        result.push_back(buffer);               
    }
 
    return result;
}

int convert(string s, string minus)
{
    int num = 0;
    minus = minus.substr(0, minus.length()-1);
    if(minus.length() == 1){
        minus += ".";
    }
    while(minus.length() != 5){
        minus += "0";
    }
    vector<string> c;
    c = split(s, ':');
    num += 3000;
    num += stod(c[2]) * 1000;
    num += stod(c[1]) * 60 * 1000;
    num += stod(c[0]) * 3600 * 1000;
    num -= stod(minus) * 1000;
    return num;
}

int solution(vector<string> lines) {
    int answer = 0;
    int a, b;
    int count;
    int result = 0;
    int start, end;
    int compStart, compEnd;
    vector<pair<int, int> > v;
    vector<string> temp;
    for(int i=0; i<lines.size(); ++i){
        temp = split(lines[i], ' ');
        a = convert(temp[1], "0s");
        b = convert(temp[1], temp[2]);
        v.push_back({a, b});
    }
    
    sort(v.begin(), v.end());
    
    for(int i=0; i<v.size(); ++i){
        start = v[i].second;
        end = v[i].first;
        count = 1;
        for(int j=i+1; j<v.size(); ++j){
            compStart = v[j].second;
            compEnd = v[j].first;
            if(end + 1000 - 1 > compStart){
                ++count;
            }
        }
        result = max(result, count);
    }
        
    return result;
}