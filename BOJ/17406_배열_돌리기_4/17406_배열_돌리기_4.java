import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static int ans = 987654321;
	static int[][] map;
	static int[][] arr;
	static int[] order;
	static boolean[] visit;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		
		for(int i=1; i<=n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr = new int[k][3];
		for(int o=0; o<k; ++o) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()); 
			int c = Integer.parseInt(st.nextToken()); 
			int s = Integer.parseInt(st.nextToken());
			r -= s;
			c -= s;
			arr[o][0] = r;
			arr[o][1] = c;
			arr[o][2] = s;
		}
		
		visit = new boolean[k];
		order = new int[k];
		for(int i=0; i<k; ++i) {
			visit[i] = true;
			order[0] = i; 
			dfs(1);
			visit[i] = false;
		}
		
		bw.write(ans + "\n");
		bw.close();
	}
	public static void dfs(int cnt) {
		if(cnt == k) {
			int[][] tempMap = new int[n+1][m+1];
			copyMap(map, tempMap);
			for(int i=0; i<k; ++i) {
				rotate(tempMap, order[i]);
			}
			calc(tempMap);
      return;
		}
		for(int i=0; i<k; ++i) {
			if(visit[i]) {
				continue;
			}
			visit[i] = true;
			order[cnt] = i; 
			dfs(cnt + 1);
			visit[i] = false;
		}
	}
	public static void calc(int[][] map) {
		for(int i=1; i<=n; ++i) {
			int sum = 0;
			for(int j=1; j<=m; ++j) {
				sum += map[i][j];
			}
			ans = Math.min(ans, sum);
		}
	}
	public static void copyMap(int[][] a, int[][] b) {
		for(int i=1; i<=n; ++i) {
			for(int j=1; j<=m; ++j) {
				b[i][j] = a[i][j];
			}
		}
	}
	public static void rotate(int[][] m, int index) {
		int r = arr[index][0]; 
		int c = arr[index][1]; 
		int s = arr[index][2];
		while(s > 0) {
			int y = r;
			int x = c;
			for(int i=0; i<4; ++i) {
				for(int j=0; j<s*2; ++j) {
					int nextY = y + dy[i];
					int nextX = x + dx[i];
					swap(m, y, x, nextY, nextX);
					y = nextY;
					x = nextX;
				}
			}
			swap(m, y, x, y, x+1);
			r += 1;
			c += 1;
			s -= 1;
		}
	}
	public static void swap(int[][] m, int ay, int ax, int by, int bx) {
		int tmp;
		tmp = m[ay][ax];
		m[ay][ax] = m[by][bx];
		m[by][bx] = tmp;
	}
}
