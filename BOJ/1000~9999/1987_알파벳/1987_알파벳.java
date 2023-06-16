import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int ans = 0;
	static int n;
	static int m;
	static char[][] map;
	static int[] alp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		alp = new int[26];
		for(int i=0; i<n; ++i) {
			String s = br.readLine();
			for(int j=0; j<m; ++j) {
				map[i][j] = s.charAt(j);
			}	
		}
		
		alp[(int)map[0][0] - 'A'] = 1;
		DFS(0, 0, 1);
		
		bw.write(ans + "");
		bw.close();
	}
	
	public static void DFS(int y, int x, int cnt) {
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		ans = Math.max(ans, cnt);
		for(int i=0; i<4; ++i) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || alp[((int)map[nextY][nextX] - 'A')] == 1) {
				continue;
			}
			alp[(int)map[nextY][nextX] - 'A'] = 1;
			DFS(nextY, nextX, cnt + 1);
			alp[(int)map[nextY][nextX] - 'A'] = 0;
		}
	}
}