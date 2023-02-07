import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int ans = 11;
	static int[][] map;
	static int[] arr = new int[10];
	static Queue<Marble> q;
	static boolean end = false;
	static boolean[][][][] visit = new boolean[10][10][10][10];
	static Marble ansMar;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		q = new LinkedList<Marble>();
		char c;
		int ry = 0, rx = 0;
		int by = 0, bx = 0;
		Marble mar;
		
		for(int i=0; i<n; ++i) {
			String s = br.readLine();
			for(int j=0; j<m; ++j) {
				c = s.charAt(j);
				switch(c) {
					case '#':
						map[i][j] = 0;
						break;
					case '.':
						map[i][j] = 1;
						break;
					case 'B':
						by = i;
						bx = j;
						map[i][j] = 1;
						break;
					case 'R':
						ry = i;
						rx = j;
						map[i][j] = 1;
						break;
					case 'O':
						map[i][j] = 2;
						break;
				}
			}
		}
		mar = new Marble(by, bx, ry, rx, 0, "");
		q.add(mar);
		while(!q.isEmpty()) {
			mar = q.poll();
			for(int i=0; i<4; ++i) {
				moveMarble(i, mar);
				if(end) {
					System.out.println(ans);
					for(int j=0; j<ans; ++j) {
						switch(ansMar.s.charAt(j)) {
						case '0':
							System.out.printf("R");
							break;
						case '1':
							System.out.printf("D");
							break;
						case '2':
							System.out.printf("L");
							break;
						case '3':
							System.out.printf("U");
							break;
						}
					}
					return;
				}
			}
		}
		System.out.println("-1");
	}
	static void moveMarble(int d, Marble mar) {
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0}; 
		boolean chk = false;
		boolean redSuc = false;
		boolean useChk = false;
		Marble nMar = new Marble(mar.by, mar.bx, mar.ry, mar.rx, mar.time+1, mar.s);
		nMar.s += d + "";
		if(mar.time >= 10) {
			return;
		}
		if(nMar.by < nMar.ry) { //파랑이 빨강보다 왼쪽 또는 위쪽
			chk = true;
		} else if (nMar.by == nMar.ry && nMar.bx < nMar.rx) {
			chk = true;
		}
		if((!chk && (d == 0 || d == 1)) || (chk && (d == 2 || d == 3))) {	// 파랑구슬부터 이동
			while(true) {
				int nextBY = nMar.by + dy[d];
				int nextBX = nMar.bx + dx[d];
				int nextRY = nMar.ry + dy[d];
				int nextRX = nMar.rx + dx[d];
				boolean moveChk = false;
				if(map[nextBY][nextBX] == 2) { // 구멍
					return;
				}
				if(map[nextBY][nextBX] == 1) { // 빈 공간
					nMar.by = nextBY;
					nMar.bx = nextBX;
					moveChk = true;
					useChk = true;
				}
				if(map[nextRY][nextRX] == 2) { // 구멍
					ans = Math.min(ans, nMar.time);
					end = true;
					ansMar = nMar;
					return;
				} 
				if(map[nextRY][nextRX] == 1 && !(nMar.by == nextRY && nMar.bx == nextRX)) { // 빈 공간
					nMar.ry = nextRY;
					nMar.rx = nextRX;
					moveChk = true;
					useChk = true;
				}
				if(!moveChk) {
					if(!useChk) {
						return;
					}
					if(!visit[nMar.by][nMar.bx][nMar.ry][nMar.rx]) {
						visit[nMar.by][nMar.bx][nMar.ry][nMar.rx] = true;
						q.add(nMar);
					}
					return;
				}
			}
		} else if ((chk && (d == 0 || d == 1)) || (!chk && (d == 2 || d == 3))) {
			while(true) {
				int nextBY = nMar.by + dy[d];
				int nextBX = nMar.bx + dx[d];
				int nextRY = nMar.ry + dy[d];
				int nextRX = nMar.rx + dx[d];
				boolean moveChk = false;
				
				if(map[nextRY][nextRX] == 2) { // 구멍
					redSuc = true;
				}
				if(map[nextRY][nextRX] == 1) { // 빈 공간
					nMar.ry = nextRY;
					nMar.rx = nextRX;
					moveChk = true;
					useChk = true;
				}
				if(map[nextBY][nextBX] == 2) { // 구멍
					return;
				}
				
				if(map[nextBY][nextBX] == 1 && (!(nextBY == nMar.ry && nextBX == nMar.rx) || redSuc)) { // 빈 공간
					nMar.by = nextBY;
					nMar.bx = nextBX;
					moveChk = true;
					useChk = true;
				}
				if(redSuc && !moveChk) { //R D L U
					ans = Math.min(ans, nMar.time);
					end = true;
					ansMar = nMar;
					return;
				}
				if(!moveChk) {
					if(!useChk) {
						return;
					}
					if(!visit[nMar.by][nMar.bx][nMar.ry][nMar.rx]) {
						visit[nMar.by][nMar.bx][nMar.ry][nMar.rx] = true;
						q.add(nMar);
					}
					return;
				}
			}
		}
	
	}
	static class Marble {
		public int by, bx, ry, rx, time;
		public String s = "";
		Marble(int by, int bx, int ry, int rx, int time, String s){
			this.by = by;
			this.bx = bx;
			this.ry = ry;
			this.rx = rx;
			this.time = time;
			this.s = s;
		}
	}
}
