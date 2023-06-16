import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int ans = 987654321;
	static int n;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		for(int i=1; i<=n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<=n; ++i) {
			DFS(i, 1<<i , 1);
		}
		bw.write(ans + "");
		bw.close();
	}
	public static void DFS(int index, int bit, int cnt) {
		if(cnt > n / 2) {
			return;
		}
		int a = 0;
		int b = 0;
		
		for(int i=1; i<=n; ++i) {
			for(int j=i+1; j<=n; ++j) {
				if((bit & (1<<i)) == 0 && (bit & (1<<j)) == 0) {
					a += map[i][j];
					a += map[j][i];
				} else if ((bit & (1<<i)) != 0 && (bit & (1<<j)) != 0) {
					b += map[i][j];
					b += map[j][i];
				}
			}
		}
		ans = Math.min(ans, Math.abs(a-b));
		for(int i=index+1; i<=n; ++i) {
			DFS(i, bit | 1<<i, cnt + 1);
		}
	}
}
