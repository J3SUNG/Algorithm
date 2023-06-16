import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int h;
	static int ans = 4;
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		map = new boolean[h+1][n+1];		
		for(int i=0; i<m; ++i) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = true;
		}
		addLadder(0, 1, 1);
		ans = ans==4?-1:ans;
		bw.write(ans + "");
		bw.flush();
		bw.close();
	}
	public static void addLadder(int cnt, int y, int x) {
		boolean init = false;
		if(cnt >= ans) { // 가지치기
			return;
		}
		if(go()) {
			ans = Math.min(ans, cnt);
			return;
		}
		for(int i=1; i<=h; ++i) {
			for(int j=1; j<n; ++j) {
				if(!init) {
					i = y;
					j = x;
					init = true;
					if(j >= n) {
						continue;
					}
				}
				if(map[i][j] || map[i][j-1] || map[i][j+1]) {
					continue;
				}
				map[i][j] = true;
				addLadder(cnt + 1, i, j + 1);
				map[i][j] = false;
			}
		}
	}
	public static boolean go() {
		int[] arr = new int [n+1];
		for(int i=1; i<=n; ++i) {
			arr[i] = i;
		}
		for(int i=1; i<=h; ++i) {
			for(int j=1; j<n; ++j) {
				if(map[i][j]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		for(int i=1; i<=n; ++i) {
			if(arr[i] != i) {
				return false;
			}
		}
		return true;
	}
}
