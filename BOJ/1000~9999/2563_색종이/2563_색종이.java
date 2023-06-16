import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		boolean[][] map = new boolean[101][101];
		for(int c=0; c<n; ++c) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int i=0; i<10; ++i) {
				for(int j=0; j<10; ++j) {
					if(!map[a+i][b+j]) {
						map[a+i][b+j] = true;
						++ans;
					}
				}
			}
		}
		
		bw.write(ans + "\n");
		bw.close();
	}
}