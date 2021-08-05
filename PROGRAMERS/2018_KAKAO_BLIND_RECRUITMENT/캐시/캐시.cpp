#include <iostream>
#include <string>
#include <vector>
using namespace std;

int solution(int cacheSize, vector<string> cities)
{
  bool check = false;
  int answer = 0;
  vector<string> cache;
  vector<string> temp;
  for (int i = 0; i < cities.size(); ++i)
  {
    for (int j = 0; j < cities[i].length(); ++j)
    {
      cities[i][j] = tolower(cities[i][j]);
    }
    if(cacheSize == 0){
      return cities.size() * 5;
    }
    if (cache.size() == 0)
    {
      cache.push_back(cities[i]);
      answer += 5;
      continue;
    }
    for (int j = 0; j < cache.size(); ++j)
    {
      if (cities[i] == cache[j])
      {
        temp.clear();
        temp.push_back(cities[i]);
        cache.erase(cache.begin() + j);
        temp.insert(temp.end(), cache.begin(), cache.end());
        cache = temp;
        ++answer;
        check = true;
        break;
      }
    }
    if (check)
    {
      check = false;
      continue;
    }
    if (cache.size() == cacheSize)
    {
      cache.erase(cache.end() - 1);
    }
    temp.clear();
    temp.push_back(cities[i]);
    temp.insert(temp.end(), cache.begin(), cache.end());
    cache = temp;
    answer += 5;
    continue;
  }

  return answer;
}

int main(int argc, char *argv[])
{
  solution(5, {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
  return 0;
}