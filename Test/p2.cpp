#include <iostream>
#include <algorithm>
#include <string>
#include <cmath>
#include <vector>
using namespace std;

bool decimal(long num)
{
  for(int i=0; i<num/2 + 1; ++i){
    if(num % i == 0){
      return false;
    }
  }
  return true;
}

string changeNumber(long num, int n)
{
  long temp; 
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
    int convertNum = 0;
    int longNum = 0;
    bool check = true;
    string num;
    string temp;
    
    num = changeNumber(n, k);
    size = num.size();
    
    for(int i=0; i<size; ++i){
      if(check){
        if(num[i] == '0'){
          for(int j=temp.size()-1; j>=0; ++j){
            longNum += (int)temp[j] * pow(10, j);
          }
          cout << temp << endl;
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
        else {
          temp += num[i];
        }
      // } else {
      //   if(num[i] == 0){
      //     check = true;
      //   }
      }
    }

    // cout << answer << endl;
    return answer;
}

int main (int argc, char *argv[])
{
  solution(437674, 3);

  return 0;
}