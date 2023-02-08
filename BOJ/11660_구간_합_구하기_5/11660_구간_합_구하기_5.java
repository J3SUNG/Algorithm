import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		for(int i=1; i<=n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; ++j) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
			}
		}
		for(int i=0; i<m; ++i) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			bw.write((map[y2][x2] - map[y2][x1-1] - map[y1-1][x2] + map[y1-1][x1-1]) + "\n");
		}
		bw.close();
	}
}
