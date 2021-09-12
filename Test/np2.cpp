#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

bool compare(pair<int, int> a, pair<int, int> b)
{
  if(a.first == b.first){
    return a.second < b.second;
  }
  return a.first < b.first;
}

long paperCuttings(int textLength, vector<int> starting, vector<int> ending) {
  long result = 0;
  vector<pair<int, int> > v;

  for(int i=0; i<starting.size(); ++i){
    v.push_back({starting[i], ending[i]});
  }    
  sort(v.begin(), v.end(), compare);
  
  for(int i=0; i<v.size() - 1; ++i){
    if(v[i].first == v[i+1].first && v[i].second == v[i+1].second){
      continue;
    }
    for(int j=i+1; j<v.size(); ++j){
      if(v[j].first == v[j+1].first && v[j].second == v[j+1].second){
        continue;
      }
      if(v[i].second < v[j].first){
        ++result;
      }
    }
  }
  return result;
}

int main(int argc, char *argv[])
{
  paperCuttings(10, {3, 1, 2, 8, 8}, {5, 3, 7, 10, 10});

  return 0;
}