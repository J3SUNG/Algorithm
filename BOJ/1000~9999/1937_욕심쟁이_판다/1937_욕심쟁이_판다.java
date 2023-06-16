import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][] dp = new int[n][n];
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };
		ArrayList<Data> al = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				al.add(new Data(i, j, map[i][j]));
				dp[i][j] = 1;
			}
		}

		Collections.sort(al, (a, b) -> a.value - b.value);

		for (int i = 0; i < al.size(); ++i) {
			for (int j = 0; j < 4; ++j) {
				int nextY = al.get(i).y + dy[j];
				int nextX = al.get(i).x + dx[j];

				if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
					continue;
				}

				if (map[nextY][nextX] > map[al.get(i).y][al.get(i).x]) {
					dp[nextY][nextX] = Math.max(dp[nextY][nextX], dp[al.get(i).y][al.get(i).x] + 1);
				}
			}
		}
		
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				ans = Math.max(ans, dp[i][j]);
			}
		}

		bw.write(ans + "\n");
		bw.close();
	}

	public static class Data {
		int y;
		int x;
		int value;

		public Data(int y, int x, int value) {
			this.y = y;
			this.x = x;
			this.value = value;
		}
	}
}