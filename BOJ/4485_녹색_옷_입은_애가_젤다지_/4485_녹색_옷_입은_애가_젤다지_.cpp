#include <iostream>
#include <cstdio>
#include <queue>
#include <functional>

#define INF 100000

using namespace std;

typedef pair<int, int> pii;

int adj[130][130];  //위치 값
int dist[130][130]; // 가중치 값

int main()
{
  int tCase = 1;
  while (tCase++)
  {
    int n;    //n*n 행렬
    cin >> n; //n*n 행렬 입력

    if (!n)
      break;

    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
      {
        dist[i][j] = INF; //거리값 전부 INF로 지정
        cin >> adj[i][j]; //n*n 행렬 값 대입
      }

    queue<pair<int, pii>> pq; // stl queue 선언

    dist[0][0] = adj[0][0];           // 시작위치 저장값에 시작위치값 대입
    pq.push({dist[0][0], pii(0, 0)}); // 시작값과 위치를 큐에 넣음

    while (!pq.empty()) //큐가 비지 않으면 반복
    {
      int cost = pq.front().first;      //cost = dist[0][0]
      int y = pq.front().second.first;  //y = push한 y값
      int x = pq.front().second.second; //x = push한 x값

      pq.pop(); //큐 pop

      if (dist[y][x] < cost) // dist[y][x] < cost 면 콘티뉴
        continue;

      if (y + 1 < n && dist[y + 1][x] > cost + adj[y + 1][x]) // x + 0 , y + 1의 가중값과 현재 위치에서의 가중치 비교
      {
        dist[y + 1][x] = cost + adj[y + 1][x];    //현재 위치에서 부터의 가중치로 변경
        pq.push({dist[y + 1][x], pii(y + 1, x)}); //현재 값과 위치 큐에 넣음
      }

      if (y - 1 >= 0 && dist[y - 1][x] > cost + adj[y - 1][x]) // x + 0 , y - 1의 가중값과 현재 위치에서의 가중치 비교
      {
        dist[y - 1][x] = cost + adj[y - 1][x];    //현재 위치에서 부터의 가중치로 변경
        pq.push({dist[y - 1][x], pii(y - 1, x)}); //현재 값과 위치 큐에 넣음
      }

      if (x + 1 < n && dist[y][x + 1] > cost + adj[y][x + 1]) // x + 1 , y + 0의 가중값과 현재 위치에서의 가중치 비교
      {
        dist[y][x + 1] = cost + adj[y][x + 1];    //현재 위치에서 부터의 가중치로 변경
        pq.push({dist[y][x + 1], pii(y, x + 1)}); //현재 값과 위치 큐에 넣음
      }

      if (x - 1 >= 0 && dist[y][x - 1] > cost + adj[y][x - 1]) // x - 1 , y + 0의 가중값과 현재 위치에서의 가중치 비교
      {
        dist[y][x - 1] = cost + adj[y][x - 1];    //현재 위치에서 부터의 가중치로 변경
        pq.push({dist[y][x - 1], pii(y, x - 1)}); //현재 값과 위치 큐에 넣음
      }
    }

    cout << "Problem " << tCase - 1 << ": " << dist[n - 1][n - 1] << endl; // 최종위치 가중치값 프린트
  }
  return 0;
}