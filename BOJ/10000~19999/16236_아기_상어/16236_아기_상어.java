import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qd = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
			int[][] test = new int[n][n];
			int cnt = 1;
		boolean[][] visit = new boolean[n][n];
		int y = 0;
		int x = 0;
		int d = 0;
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, -1, 0, 1};
		int level = 2;
		int eat = 1;
		int nextLevel = 2;
		int ans = 0;
		int findD = 987654321;
		int findY = 987654321;
		int findX = 987654321;
		boolean chk = false;
		for(int i=0; i<n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					map[i][j] = 0;
					y = i;
					x = j;
				}
			}
		}
		qy.add(y);
		qx.add(x);
		qd.add(0);
		while(!qy.isEmpty()) {
			int nextY, nextX;
			y = qy.poll();
			x = qx.poll();
			d = qd.poll();
			visit[y][x] = true;
			for(int i=0; i<4; ++i) {
				nextY = y + dy[i];
				nextX = x + dx[i];
				if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= n || visit[nextY][nextX]) {
					continue;
				}
				if(map[nextY][nextX] == level || map[nextY][nextX] == 0) {
					if(!chk) {
						qy.add(nextY);
						qx.add(nextX);
						qd.add(d + 1);
						visit[nextY][nextX] = true;
					}
				} else if(map[nextY][nextX] <= eat){
					chk = true;
					if(findD > d) {
						findD = d;
						findY = nextY;
						findX = nextX;
					} else if(findD == d) {
						if(findY > nextY) {
							findD = d;
							findY = nextY;
							findX = nextX;
						}
						if(findY == nextY && findX > nextX) {
							findD = d;
							findY = nextY;
							findX = nextX;
						}
					}
				}
			}
			if(chk && qy.isEmpty()) {
				map[findY][findX] = 0;
				test[findY][findX] = cnt++;
				--nextLevel;
				if(nextLevel == 0) {
					++level;
					++eat;
					nextLevel = level;
				}
				ans += findD + 1;
				qy.add(findY);
				qx.add(findX);
				qd.add(0);
				chk = false;
				findD = 987654321;
				findY = 987654321;
				findX = 987654321;
				for(int j=0; j<n; ++j) {
					for(int k=0; k<n; ++k) {
						visit[j][k] = false;
					}
				}
			}
		}
		System.out.println(ans);
	}
}