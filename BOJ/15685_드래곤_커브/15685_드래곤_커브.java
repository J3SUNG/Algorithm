import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int ans = 0;
	static int[] dy = {0, -1, 0, 1}; //동 북 서 남
	static int[] dx = {1, 0, -1, 0};
	static int[] pattern = new int[1024];
	static int[][] map = new int[101][101];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		curve();

		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			map[y][x] = 1;
			for(int j=0; j<(1<<g); ++j) {
				y += dy[(pattern[j] + d) % 4];
				x += dx[(pattern[j] + d) % 4];
				map[y][x] = 1;
			}
		}
		find();
		bw.write(ans + "");
		bw.flush();
	}
	public static void find() {
		for(int i=0; i<100; ++i) {
			for(int j=0; j<100; ++j) {
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1&& map[i+1][j+1] == 1) {
					++ans;
				}
			}
		}
	}
	public static void curve() {
		int standard = 1;
		int prev = 1;
		int compare = 1;
		for(int i=1; i<1024; ++i) {
			++prev;
			if(i == standard) {
				compare = i;
				standard*=2;
				prev = 1;
			}
			pattern[i] = (pattern[compare - prev] + 1) % 4;
		}
	}
}