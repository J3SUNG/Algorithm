import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int ans = 0;
	static int n;
	static int[][] map;
	static int[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new int[n][n];
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i=0; i<n; ++i) {
			String st = br.readLine();
			for(int j=0; j<n; ++j) {
				map[i][j] = st.charAt(j) == 'R' ? 1 : st.charAt(j) == 'G' ? 2 : 4; 
			}
		}
		
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				if(visit[i][j] == 1) {
					continue;
				}
				DFS(i, j, map[i][j]);
				++cnt1;
			}
		}
		
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				visit[i][j] = 0;
			}
		}
		
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				if(visit[i][j] == 1) {
					continue;
				}
				DFS2(i, j, map[i][j] == 4 ? 4 : 3);
				++cnt2;
			}
		}
		
		bw.write(cnt1 + " " + cnt2 + "\n");
		bw.close();
	}
	
	public static void DFS(int y, int x, int find) {
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		for(int i=0; i<4; ++i) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= n || visit[nextY][nextX] == 1) {
				continue;
			}
			if(map[nextY][nextX] == find) {
				visit[nextY][nextX] = 1;
				DFS(nextY, nextX, find);
			}
		}
	}
	public static void DFS2(int y, int x, int find) {
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		for(int i=0; i<4; ++i) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= n || visit[nextY][nextX] == 1) {
				continue;
			}
			if((map[nextY][nextX] & find) != 0) {
				visit[nextY][nextX] = 1;
				DFS2(nextY, nextX, find);
			}
		}
	}
}