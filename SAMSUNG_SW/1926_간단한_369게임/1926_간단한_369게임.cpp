#include<iostream>
#include<string>
using namespace std;
int main(int argc, char** argv)
{
    int n;
    int count;
    string s;
     
    cin >> n;
     
    for(int i=1; i<=n; ++i){
        count = 0;
        s = to_string(i);
        for(int j=0; j<s.size(); ++j){
            if(s[j] == '3' || s[j] == '6' || s[j] == '9'){
                ++count;
            }   
        }
        if(count > 0){
            for(int k=0; k<count; ++k){
                cout << "-";   
            }
        } else {
            cout << s;
        }
        cout << " ";
    }
    return 0;
}