import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Data> q = new LinkedList<>();

		int ans = 0;
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][] map = new int[h][w];
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		int ay = 0;
		int ax = 0;
		
		for (int i = 0; i < h; ++i) {
			String str = br.readLine();
			for (int j = 0; j < w; ++j) {
				map[i][j] = (str.charAt(j) == '.' ? -1 : (str.charAt(j) == '*' ? -2 : -3));
				if(map[i][j] == -3) {
					ay = i;
					ax = j;
				}
			}
		}
		
		map[ay][ax] = 0;
		q.add(new Data(ay, ax, 0));
		while(!q.isEmpty()) {
			Data p = q.poll();
			for(int i=0; i<4; ++i) {
				int nextY = p.y;
				int nextX = p.x;
				while(true) {
					nextY += dy[i];
					nextX += dx[i];
					if(nextY < 0 || nextX < 0 || nextY >= h || nextX >= w) {
						break;
					}
					
					if(map[nextY][nextX] == -3) {
						ans = p.cnt;
						while(!q.isEmpty()) {
							q.poll();
						}
						break;
					} else if(map[nextY][nextX] == -2) {
						break;
					} else if(map[nextY][nextX] == -1) {
						map[nextY][nextX] = p.cnt;
						q.add(new Data(nextY, nextX, p.cnt + 1));
					} else if(map[nextY][nextX] >= 0 && map[nextY][nextX] != p.cnt) {
						break;
					}
				}
			}
		}

		bw.write(ans + "");
		bw.close();
	}

	public static class Data {
		public int y;
		public int x;
		public int cnt;
		public Data(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
