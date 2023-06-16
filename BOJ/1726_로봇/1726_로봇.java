import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int result = 0;
		int map[][] = new int[n][m];
		int visit[][][] = new int[n][m][4];
		int sy, sx, sd;
		int ey, ex, ed;
		int[] my = { 0, 1, 0, -1 };
		int[] mx = { 1, 0, -1, 0 };
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		sy = Integer.parseInt(st.nextToken()) - 1;
		sx = Integer.parseInt(st.nextToken()) - 1;
		sd = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine());
		ey = Integer.parseInt(st.nextToken()) - 1;
		ex = Integer.parseInt(st.nextToken()) - 1;
		ed = Integer.parseInt(st.nextToken()) - 1;

		if (sd == 1) {
			sd = 2;
		} else if (sd == 2) {
			sd = 1;
		}
		if (ed == 1) {
			ed = 2;
		} else if (ed == 2) {
			ed = 1;
		}

		visit[sy][sx][sd] = 1;
		q.add(new Pair(sy, sx, sd, 0));
		while (!q.isEmpty()) {
			int y = q.peek().y;
			int x = q.peek().x;
			int d = q.peek().d;
			int c = q.peek().c;
			q.poll();
			if (ey == y && ex == x && ed == d) {
				result = c;
				break;
			}
			for (int i = 1; i <= 3; ++i) {
				int nextY = y + (my[d] * i);
				int nextX = x + (mx[d] * i);

				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || map[nextY][nextX] == 1) {
					break;
				}
				if (visit[nextY][nextX][d] == 1) {
					continue;
				}

				visit[nextY][nextX][d] = 1;
				q.add(new Pair(nextY, nextX, d, c + 1));
			}
			if (visit[y][x][(4 + d - 1) % 4] == 0) {
				visit[y][x][(4 + d - 1) % 4] = 1;
				q.add(new Pair(y, x, (4 + d - 1) % 4, c + 1));
			}
			if (visit[y][x][(d + 1) % 4] == 0) {
				visit[y][x][(d + 1) % 4] = 1;
				q.add(new Pair(y, x, (d + 1) % 4, c + 1));
			}
		}

		bw.write(result + "");
		bw.close();
	}

	static public class Pair {
		int y;
		int x;
		int d;
		int c;

		public Pair(int y, int x, int d, int c) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.c = c;
		}
	}
}
