import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int[][] visit;
	static int prevCnt = 0;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 2][m + 2];
		visit = new int[n + 2][m + 2];

		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			for (int i = 0; i <= n + 1; ++i) {
				for (int j = 0; j <= m + 1; ++j) {
					if (i == 0 || j == 0 || i == n + 1 || j == m + 1) {
						DFS(i, j);
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i <= n + 1; ++i) {
				for (int j = 0; j <= m + 1; ++j) {
					if(visit[i][j] == 1 && map[i][j] == 1) {
						map[i][j] = 0;
						++cnt;
					}
					visit[i][j] = 0;
				}
			}
			if(cnt == 0) {
				break;
			}
			prevCnt = cnt;
			++ans;
		}

		bw.write(ans + "\n");
		bw.write(prevCnt + "\n");
		bw.close();
	}

	public static void DFS(int y, int x) {
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };

		for (int i = 0; i < 4; ++i) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];

			if (nextY < 0 || nextX < 0 || nextY > n + 1 || nextX > m + 1 || visit[nextY][nextX] == 1) {
				continue;
			}
			visit[nextY][nextX] = 1;
			if (map[nextY][nextX] == 1) {
			} else if (map[nextY][nextX] == 0) {
				DFS(nextY, nextX);
			}
		}
	}
}
