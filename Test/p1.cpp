#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <sstream>
using namespace std;

vector<string> split(string input, char delimiter) {
    vector<string> answer;
    stringstream ss(input);
    string temp;
 
    while (getline(ss, temp, delimiter)) {
        answer.push_back(temp);
    }
 
    return answer;
}

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
  int index;
  string badUser;
  string normalUser;
  string prevStr = "";
  vector<int> user(id_list.size());
  vector<int> answer(id_list.size());
  
  sort(report.begin(), report.end());
  for(int i=0; i<report.size(); ++i){
    if(report[i] == prevStr){
      continue;
    }
    badUser = split(report[i], ' ')[1];
    index = find(id_list.begin(), id_list.end(), badUser) - id_list.begin();
    ++user[index];
    prevStr = report[i];
  } 
  for(int i=0; i<report.size(); ++i){
    if(report[i] == prevStr){
      continue;
    }
    badUser = split(report[i], ' ')[1];
    index = find(id_list.begin(), id_list.end(), badUser) - id_list.begin();
    if(user[index] >= k){
      normalUser = split(report[i], ' ')[0];
      index = find(id_list.begin(), id_list.end(), normalUser) - id_list.begin();
      ++answer[index];
      prevStr = report[i];
    }
  } 
  for(int i=0; i<answer.size(); ++i){
    cout << answer[i] << endl;
  }
  return answer;
}

int main(int argc, char *argv[])
{
  int k = 2;
  vector<string> id_list;
  vector<string> report;
  id_list.push_back("muzi");
  id_list.push_back("frodo");
  // id_list.push_back("apeach");
  // id_list.push_back("neo");
  report.push_back("frodo muzi");  
  report.push_back("muzi frodo");
  report.push_back("muzi frodo");
  report.push_back("muzi frodo");
  report.push_back("frodo muzi");  
  report.push_back("muzi frodo");
  report.push_back("muzi frodo");
  // report.push_back("frodo neo");
  // // report.push_back("muzi neo");
  // report.push_back("apeach muzi");
  // report.push_back("apeach muzi");
  // report.push_back("apeach muzi");
  // report.push_back("apeach muzi");    
    
  solution(id_list, report, k);

  return 0;
}