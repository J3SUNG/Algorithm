import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int[][] map = new int[h][w];
			int[][] visit = new int[h][w];
			
			if(w == 0 && h == 0) {
				break;
			}
			
			for(int i=0; i<h; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; ++i) {
				for(int j=0; j<w; ++j) {
					if(map[i][j] == 1 && visit[i][j] == 0) {
						DFS(h, w, i, j, map, visit);
						++ans;
					}
				}
			}
			bw.write(ans + "\n");
		}
		bw.close();
	}
	public static void DFS(int h, int w, int y, int x, int[][] map, int[][] visit) {
		int[] dy = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
		int[] dx = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
		
		for(int i=0; i<9; ++i) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if(nextY < 0 || nextX < 0 || nextY >= h || nextX >= w || visit[nextY][nextX] == 1 || map[nextY][nextX] == 0) {
				continue;
			}
			visit[nextY][nextX] = 1;
			DFS(h, w, nextY, nextX, map, visit);
		}
	}
}
