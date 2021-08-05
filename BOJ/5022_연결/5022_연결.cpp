#include <iostream>
#include <cstring>
#include <string>
#include <queue>
#include <algorithm>
#define MAX 987654321
using namespace std;

bool flag;
int n, m;
int result;
int dist[2];
int mx[4] = { 0, 1, 0, -1 };
int my[4] = { 1, 0, -1, 0 };
int map[102][102];
int visit[102][102];
queue<pair<pair<int, int>, int> > q;

void connect(int sx, int sy, int ex, int ey, int count)
{
	queue<pair<pair<int, int>, int > > con;
	con.push(make_pair(make_pair(sy, sx), count));

	while (!con.empty()) {
		int a = con.front().first.first;
		int b = con.front().first.second;
		int c = con.front().second;
		con.pop();

		for (int i = 0; i < 4; ++i) {
			int y = a + my[i];
			int x = b + mx[i];

			if (y == ey && x == ex) {
				while (!con.empty()) {
					con.pop();
				}
				return;
			}

			if (y < 0 || x < 0 || y > n || x > m) {
				continue;
			}

			if (c - 1 == visit[y][x] && visit[y][x] != 0) {
				map[y][x] = 2;
				con.push(make_pair(make_pair(y, x), c - 1));
				break;
			}
		}
	}
}

bool BFS(int sx, int sy, int ex, int ey, int index)
{
	bool exit = false;

	q.push(make_pair(make_pair(sy, sx), 0));

	while (!q.empty()) {
		int a = q.front().first.first;
		int b = q.front().first.second;
		int c = q.front().second;
		q.pop();

		for (int i = 0; i < 4; ++i) {
			int y = a + my[i];
			int x = b + mx[i];

			if (y == ey && x == ex) {
				dist[index] += c + 1;
				exit = true;
				while (!q.empty()) {
					q.pop();
				}
				break;
			}

			if (x < 0 || y < 0 || x > m || y > n) {
				continue;
			}

			if (!visit[y][x] && map[y][x] == 0) {
				q.push(make_pair(make_pair(y, x), c + 1));
				visit[y][x] = c + 1;
			}
		}
	}
	if (exit) {
		return true;
	}

	return false;
}

int main(int argc, char* argv[])
{
	int Asx, Asy;
	int Aex, Aey;
	int Bsx, Bsy;
	int Bex, Bey;

	cin >> m >> n;
	cin >> Asx >> Asy;
	cin >> Aex >> Aey;
	cin >> Bsx >> Bsy;
	cin >> Bex >> Bey;

	flag = false;
	memset(map, 0, sizeof(map));
	map[Asy][Asx] = 1;
	map[Aey][Aex] = 1;
	map[Bsy][Bsx] = 1;
	map[Bey][Bex] = 1;

	result = MAX;
	dist[0] = 0;
	memset(visit, 0, sizeof(visit));
	if (BFS(Asx, Asy, Aex, Aey, 0)) {
		connect(Aex, Aey, Asx, Asy, dist[0]);
		memset(visit, 0, sizeof(visit));
		flag = true;
	}
	if (flag && BFS(Bsx, Bsy, Bex, Bey, 0)) {
		result = dist[0];
	}

	flag = false;
	memset(map, 0, sizeof(map));
	map[Asy][Asx] = 1;
	map[Aey][Aex] = 1;
	map[Bsy][Bsx] = 1;
	map[Bey][Bex] = 1;
	memset(visit, 0, sizeof(visit));
	dist[1] = 0;
	if(BFS(Bsx, Bsy, Bex, Bey, 1)) {
		connect(Bex, Bey, Bsx, Bsy, dist[1]);
		memset(visit, 0, sizeof(visit));
		flag = true;
	}
	if (flag && BFS(Asx, Asy, Aex, Aey, 1)) {
		result = min(result, dist[1]);
	}
	if(result == MAX) {
		cout << "IMPOSSIBLE" << endl;
	}
	else {
		cout << result << endl;
	}

	return 0;
}
