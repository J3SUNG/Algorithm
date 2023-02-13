import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[][] map = new int[r][c];
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		int ay1 = 0;
		int ay2 = 0;
		int ax = 0;
		
		for(int i=0; i<r; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					ay2 = i;
				}
			}
		}
		ay1 = ay2 - 1;

		int time = 0;
		while(time < t) {
			int[][] temp = new int[r][c];
			for(int i=0; i<r; ++i) {
				for(int j=0; j<c; ++j) {
					if(map[i][j] <= 0) {
						continue;
					}
					for(int k=0; k<4; ++k) {
						int nextY = i + dy[k];
						int nextX = j + dx[k];
						if(nextY < 0 || nextX < 0 || nextY >= r || nextX >= c || map[nextY][nextX] < 0) {
							continue;
						}
						temp[nextY][nextX] += map[i][j] / 5;
						temp[i][j] -= map[i][j] / 5;
					}
				}
			}
			for(int i=0; i<r; ++i) {
				for(int j=0; j<c; ++j) {
					if((i == ay1 || i == ay2) && j == ax) {
						continue;
					}
					map[i][j] += temp[i][j];
				}
			}
			int y = ay1 - 1; // 위
			int x = ax;
			int d = 3;
			while(true) {
				int nextY = y + dy[d];
				int nextX = x + dx[d];
				if(nextY == ay1 && nextX == ax) {
					break;
				}
				if(nextY < 0 || nextX < 0 || (d == 1 && nextY > ay1) || nextX >= c) {
					d = (d + 1) % 4;
					continue;
				}
				map[y][x] = map[nextY][nextX];
				map[nextY][nextX] = 0;
				y = nextY;
				x = nextX;
			}
			y = ay2 + 1; // 아래
			x = ax;
			d = 1;
			while(true) {
				int nextY = y + dy[d];
				int nextX = x + dx[d];
				if(nextY == ay2 && nextX == ax) {
					break;
				}
				if((d == 3 && nextY < ay2) || nextX < 0 || nextY >= r || nextX >= c) {
					d = (d + 3) % 4;
					continue;
				}
				map[y][x] = map[nextY][nextX];
				map[nextY][nextX] = 0;
				y = nextY;
				x = nextX;
			}
			++time;
		}
		for(int i=0; i<r; ++i) {
			for(int j=0; j<c; ++j) {
				ans += map[i][j];
			}
		}
		ans += 2;
		bw.write(ans + "");
		bw.close();
	}
}
