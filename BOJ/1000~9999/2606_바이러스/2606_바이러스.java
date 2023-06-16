import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int ans = 0;
	static int n;
	static int m;
	static boolean[][] link;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		link = new boolean[n+1][n+1];
		visit = new boolean[n+1];
		for(int i=0; i<m; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			link[a][b] = true;
			link[b][a] = true;
		}
		DFS(1);
		bw.write(ans + "");
		bw.close();
	}
	public static void DFS(int index) {
		visit[index] = true;
		for(int i=1; i<=n; ++i) {
			if(!visit[i] && link[index][i]) {
				++ans;
				DFS(i);
			}
		}
	}
}
