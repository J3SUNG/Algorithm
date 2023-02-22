import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int m;
	static int a;
	static int ans;
	static int[] aMove;
	static int[] bMove;
	static int[][] charger;
	static int[][] map;
	static int[][] visit;
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int ts = Integer.parseInt(br.readLine());
		for(int t=1; t<=ts; ++t) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			aMove = new int[m];
			bMove = new int[m];
			charger = new int[a][4];
			map = new int[10+1][10+1];
			visit = new int[10+1][10+1];
			st = new StringTokenizer(br.readLine());
			int ay = 1;
			int ax = 1;
			int by = 10;
			int bx = 10;
			for(int i=0; i<m; ++i) {
				aMove[i] = Integer.parseInt(st.nextToken());
			}			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; ++i) {
				bMove[i] = Integer.parseInt(st.nextToken());
			}			
			for(int i=0; i<a; ++i) {
				st = new StringTokenizer(br.readLine());
				charger[i][1] = Integer.parseInt(st.nextToken());
				charger[i][0] = Integer.parseInt(st.nextToken());
				charger[i][2] = Integer.parseInt(st.nextToken());
				charger[i][3] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<a; ++i) {
				int y = charger[i][0];
				int x = charger[i][1];
				int c = charger[i][2];
				visit[y][x] = 1;
				setBC(i, y, x, c);
				visit[y][x] = 0;
			}
			calc(ay, ax, by, bx);
			for(int i=0; i<m; ++i) {
				ay += dy[aMove[i]];
				ax += dx[aMove[i]];
				by += dy[bMove[i]];
				bx += dx[bMove[i]];
				calc(ay, ax, by, bx);
			}
			bw.write("#" + t + " " + ans + "\n");
		}
		bw.close();
	}
	static void calc(int ay, int ax, int by, int bx) {
		int aSum = 0;
		int bSum = 0;
		int sum = 0;
		if((map[ay][ax] & map[by][bx])!=0) {
			int[] aIndex = {-1, -1};
			int[] bIndex = {-1, -1};
			int interValue = 0;
			for(int i=0; i<a; ++i) {
				if((map[ay][ax] & (1<<i))!=0 && (map[by][bx] & (1<<i))!=0) {
					if(interValue < charger[i][3]) {
						interValue = charger[i][3];
					}
				}
				if((map[ay][ax] & (1<<i))!=0) {
					if(aSum <= charger[i][3]){
						aSum = charger[i][3];
						aIndex[1] = aIndex[0];
						aIndex[0] = i;
					} else if(aIndex[1] == -1 || charger[aIndex[1]][3] <= charger[i][3]){
						aIndex[1] = i;
					}
				}
				if((map[by][bx] & (1<<i))!=0) {
					if(bSum <= charger[i][3]){
						bSum = charger[i][3];
						bIndex[1] = bIndex[0];
						bIndex[0] = i;
					} else if(bIndex[1] == -1 || charger[bIndex[1]][3] <= charger[i][3]){
						bIndex[1] = i;
					}
				}
			}
			if(aIndex[0] != bIndex[0]) {
				sum = charger[aIndex[0]][3] + charger[bIndex[0]][3];
			} else {
				if(aIndex[1] != -1) {
					sum = Math.max(sum, charger[bIndex[0]][3] + charger[aIndex[1]][3]);	
				}
				if(bIndex[1] != -1) {
					sum = Math.max(sum, charger[aIndex[0]][3] + charger[bIndex[1]][3]);
				}				
			}
			sum = Math.max(sum, interValue);
			ans += sum;
			return;			
		} else {
			if(map[by][bx] > 0) {
				for(int i=0; i<a; ++i) {
					if((map[by][bx] & (1<<i))==0) {
						continue;
					}
					bSum = Math.max(bSum, charger[i][3]);
				}
			}
			if(map[ay][ax] > 0) {
				for(int i=0; i<a; ++i) {
					if((map[ay][ax] & (1<<i))==0) {
						continue;
					}
					aSum = Math.max(aSum, charger[i][3]);
				}
			}
		}		
		ans += aSum + bSum;
	}
	static void setBC(int index, int y, int x, int c) {
		map[y][x] = (map[y][x] | (1<<index));
		if(c == 0) {
			return;
		}		
		for(int i=1; i<=4; ++i) {
			int nextY = y+dy[i];
			int nextX = x+dx[i];
			if(nextY <= 0 || nextX <= 0 || nextY > 10 || nextX > 10 || visit[nextY][nextX] == 1) {
				continue;
			}
			visit[nextY][nextX] = 1;
			setBC(index, nextY, nextX, c-1);
			visit[nextY][nextX] = 0;
		}
	}
}