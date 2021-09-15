#include <iostream>
#include <cstring>
#include <string>
#include <vector>
using namespace std;

bool result[1 << 8];

void makeCombination(int index, vector<vector<int> > pbid, int bit) {
    if(index == pbid.size()){
        result[bit] = true;
        return;
    }
    for(int i=0; i<pbid[index].size(); ++i){
        int inputBit = (1 << pbid[index][i]);
        if(!(bit & inputBit)){
            makeCombination(index+1, pbid, bit + (1 << pbid[index][i]));   
        }
    }
}

bool checkPossible(string a, string b)
{
    if(a.length() != b.length()){
        return false;
    }
    
    for(int i=0; i<a.length(); ++i){
        if(b[i] == '*'){
            continue;
        }
        if(a[i] != b[i]){
            return false;
        }
    }
    return true;
}

int solution(vector<string> userId, vector<string> bannedId) 
{
    int answer = 0;
    vector<vector<int> > possibleBid(bannedId.size());
    vector<bool> check(8, false);
    vector<string> checkId(8);
    memset(result, false, sizeof(result));
    
    for(int i=0; i<userId.size(); ++i){
        for(int j=0; j<bannedId.size(); ++j){
            if(checkPossible(userId[i], bannedId[j])){
                possibleBid[j].push_back(i);
            }
        }
    }
        
    makeCombination(0, possibleBid, 0);
    
    for(int i=0; i<256; ++i){
        if(result[i]){
            ++answer;
        }
    }
    
    return answer;
}