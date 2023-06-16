import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int cnt;
	static int m;
	static int[][] map;
	static int[][] visit;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ans = 0;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new int[n][m];
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					q.add(new Pair(i, j));
				}
			}
		}

		int cycle = 0;
		while (true) {
			while (!q.isEmpty()) {
				Pair p = q.poll();
				for (int i = 0; i < 4; ++i) {
					int nextY = p.y + dy[i];
					int nextX = p.x + dx[i];
					if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) {
						continue;
					}
					if (map[nextY][nextX] <= 0) {
						++visit[p.y][p.x];
					}
				}
			}

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (visit[i][j] > 0) {
						map[i][j] -= visit[i][j];
						visit[i][j] = 0;
					}
					if (map[i][j] > 0) {
						q.add(new Pair(i, j));
					}
				}
			}

			if (q.size() == 0) {
				break;
			}
			cnt = 0;
			DFS(q.peek());
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					visit[i][j] = 0;
				}
			}
			++cycle;
			if (cnt < q.size()) {
				ans = cycle;
				break;
			}
		}

		bw.write(ans + "\n");
		bw.close();
	}

	public static void DFS(Pair p) {
		visit[p.y][p.x] = 1;
		++cnt;
		for (int i = 0; i < 4; ++i) {
			int nextY = p.y + dy[i];
			int nextX = p.x + dx[i];
			if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || visit[nextY][nextX] == 1 || map[nextY][nextX] <= 0) {
				continue;
			}
			DFS(new Pair(nextY, nextX));
		}
	}

	public static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
