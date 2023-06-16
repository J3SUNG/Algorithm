import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int ans = 1;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0; i<n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		for(int h=1; h<=100; ++h) {
			InitVisit();
			int res = 0;
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					if(visit[i][j] || map[i][j] - h <= 0) {
						continue;
					}
					DFS(i, j, h);
					++res;
				}
			}
			ans = Math.max(ans, res);
		}
		bw.write(ans + "");
		bw.close();
	}
	public static void InitVisit()
	{
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				visit[i][j] = false;
			}
		}
	}
	public static void DFS(int y, int x, int h) {
		visit[y][x] = true;
		for(int i=0; i<4; ++i) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= n || visit[nextY][nextX] || map[nextY][nextX] - h <= 0) {
				continue;
			}
			DFS(nextY, nextX, h);
		}
	}
}
