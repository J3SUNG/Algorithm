#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool decimal(int num)
{
  for(int i=0; i<num/2 + 1; ++i){
    if(num % i == 0){
      return false;
    }
  }
  return true;
}

string changeNumber(int num, int n)
{
  int temp; 
  string value;
  string arr[10] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
 
  while (num / n != 0)
  {
    temp = num % n;
    value = arr[temp] + value;
    num /= n;
  }
  value = arr[num % n] + value;

  return value;
}

int solution(int n, int k) {
    int answer = 0;
    int size;
    long longNum;
    bool check = true;
    string num;
    
    num = changeNumber(n, k);
    size = num.size();
    
    for(int i=0; i<size; ++i){
      if(check){
        if(num[i] == '0'){
          longNum = stol(num);
          // num = changeNumber(stol(num), 10);
          // cout << num << endl;
          // if(decimal(stoi(temp))){
          //   ++answer;
          // }
          // temp = "";
          // check = false;
        } 
        // else if(i+1 == size){
        //   temp = changeNumber(stoi(num), 10);
        //   if(decimal(stoi(temp))){
        //     ++answer;
        //   }
        // } 
        // else {
        //   temp += num[i];
      //   }
      // } else {
      //   if(num[i] == 0){
      //     check = true;
      //   }
      }
    }

    // cout << answer << endl;
    return answer;
}