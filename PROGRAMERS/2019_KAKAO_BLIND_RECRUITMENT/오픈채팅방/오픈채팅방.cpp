#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <map>
using namespace std;

vector<string> solution(vector<string> record)
{
  vector<string> answer;
  map<string, string> m;
  string command;
  string id;
  string nickname;

  for (string input : record)
  {
    stringstream ss(input);
    ss >> command;
    ss >> id;
    if (command == "Enter" || command == "Change")
    {
      ss >> nickname;
      m[id] = nickname;
    }
  }

  for (string input : record)
  {
    stringstream ss(input);
    ss >> command;
    ss >> id;
    if (command == "Enter")
    {
      nickname = (m.find(id)->second);
      answer.push_back(nickname + "님이 들어왔습니다.");
    }
    else if (command == "Leave")
    {
      nickname = (m.find(id)->second);
      answer.push_back(nickname + "님이 나갔습니다.");
    }
  }
  return answer;
}

int main(int argc, char *argv[])
{
  vector<string> record;
  record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
  solution(record);

  return 0;
}