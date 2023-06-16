#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

vector<pair<string, vector<int>>> v;

int compare(pair<string, vector<int>> v1, pair<string, vector<int>> v2)
{
  if (v1.second[0] == v2.second[0])
  {
    if (v1.second[1] == v2.second[1])
    {
      if (v1.second[2] == v2.second[2])
      {
        return v1.first < v2.first;
      }
      return v1.second[2] > v2.second[2];
    }
    return v1.second[1] < v2.second[1];
  }
  return v1.second[0] > v2.second[0];
}

int main(int argc, char *argv[])
{
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  int n;
  int kor;
  int eng;
  int math;
  string s;

  cin >> n;

  for (int i = 0; i < n; ++i)
  {
    vector<int> score;
    cin >> s;
    cin >> kor;
    cin >> eng;
    cin >> math;

    score.push_back(kor);
    score.push_back(eng);
    score.push_back(math);
    v.push_back(make_pair(s, score));
  }

  sort(v.begin(), v.end(), compare);

  for (int i = 0; i < v.size(); ++i)
  {
    cout << v[i].first << "\n";
  }

  return 0;
}