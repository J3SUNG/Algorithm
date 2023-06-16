import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int ans = -1;
	static int[] root;
	static int[][] child;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		root = new int[n+1];
		child = new int[n+1][n+1];
		visit = new int[n+1];
		for(int i=0; i<m; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			root[y] = x;
			for(int j=0; j<n; ++j) {
				if(child[x][j] == 0) {
					child[x][j] = y;
					break;
				}
			}
		}
		visit[a] = 1;
		DFS(a, b, 0);
		
		bw.write(ans + "\n");
		bw.close();
	}
	public static void DFS(int cur, int find, int cnt) {
		if(ans >= 0) {
			return;
		}
		if(cur == find) {
			ans = cnt;
			return;
		}
		if(root[cur] != 0 && visit[root[cur]] == 0 && root[cur] > 0) {
			visit[root[cur]] = 1;
			DFS(root[cur], find, cnt + 1);
		}
		for(int i=0; i<child[cur].length; ++i) {
			if(visit[child[cur][i]] == 0) {
				visit[child[cur][i]] = 1;
				DFS(child[cur][i], find, cnt + 1);
			}
		}
	}
}
