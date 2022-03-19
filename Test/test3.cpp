#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> goods) {
    int bit;
    bool check = false;
    string temp;
    string com_str;
    vector<string> result;
    vector<string> answer;
    vector<vector<string>> str_zip;
    vector<string> str;
    vector<vector<vector<string>>> v;

    for(int i=0; i<goods.size(); ++i){
        str_zip.clear();
        for(int j=0; j<goods[i].length(); ++j){ 
            str.clear();
            for(int k=0; k<goods[i].length()-j; ++k){ 
                temp = "";
                for(int l=0; l<=j; ++l){ 
                    temp += goods[i][k+l];
                }
                str.push_back(temp);
            }
            str_zip.push_back(str);
        }        
        v.push_back(str_zip);
    }
    
    for(int i=0; i<v.size(); ++i){
        result.clear();
        for(int j=0; j<v[i].size(); ++j){ 
            bit = 0;
            for(int l=0; l<v[i][j].size(); ++l){
                for(int k=0; k<v.size(); ++k){
                    if(i==k || v[k].size()<=j){
                        continue;
                    }
                    for(int m=0; m<v[k][j].size(); ++m){
                        if(v[i][j][l] == v[k][j][m]){ 
                            bit = (bit | (1 << l)); 
                            break;
                        }
                    }                    
                }
            }
            
            if(bit != (1 << v[i][j].size()) - 1){
                check = true;
                for(int n=0; n<v[i][j].size(); ++n){
                    if(bit & (1 << n)){
                        continue;
                    } else {
                        result.push_back(v[i][j][n]);
                    }
                }
                sort(result.begin(), result.end());
                result.erase(unique(result.begin(),result.end()),result.end());                
            }
            if(check){
                com_str = "";
                for(int p=0; p<result.size(); ++p){
                    if(com_str == ""){
                        com_str = result[p];
                    } else {
                        com_str += " " + result[p];
                    }
                }
                answer.push_back(com_str);
                check = false;
                break;
            }
            if(j+1==v[i].size()){
                answer.push_back("None");
            }
        }        
    }

    return answer;
}