#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

const int INF = 987654321;
int vertex, edge;
int start;
int u, v, w;
vector<pair<int, int>> map[20010];
priority_queue<pair<int, int>> pq;

vector<int> solve()
{
  int location;
  int weight;
  int nextLocation;
  int nextWeight;
  vector<int> result(vertex, INF);

  result[start] = 0;

  pq.push(make_pair(0, start));

  while (!pq.empty())
  {
    weight = -pq.top().first;
    location = pq.top().second;

    pq.pop();

    if (result[location] < weight)
    {
      continue;
    }

    for (int i = 0; i < map[location].size(); ++i)
    {
      nextLocation = map[location][i].first;
      nextWeight = weight + map[location][i].second;

      if (result[nextLocation] > nextWeight)
      {
        result[nextLocation] = nextWeight;
        pq.push(make_pair(-nextWeight, nextLocation));
      }
    }
  }

  return result;
}

int main(int argc, char *argv[])
{
  scanf("%d", &vertex);
  scanf("%d", &edge);
  scanf("%d", &start);

  vertex++;

  for (int i = 1; i <= edge; ++i)
  {
    scanf("%d", &u);
    scanf("%d", &v);
    scanf("%d", &w);

    map[u].push_back(make_pair(v, w));
  }

  vector<int> result = solve();

  for (int i = 1; i < vertex; ++i)
  {
    result[i] == INF ? printf("INF\n") : printf("%d\n", result[i]);
  }

  return 0;
}