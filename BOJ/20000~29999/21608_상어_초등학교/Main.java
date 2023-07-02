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
		StringTokenizer st;
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		int[][] map = new int[n+1][n+1];
		int[][] order = new int[n+1][n+1];
		int[][] like = new int[(n*n)+1][5];
		for(int i=1; i<=n*n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; ++j) {
				like[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int nextY, nextX;
		for(int s=1; s<=n*n; ++s) { // s가 아닌 like[0]
			int stu = like[s][0];
			int goodLocY = 0;
			int goodLocX = 0;
			int maxLikeCnt = 0;
			int maxEmptyCnt = 0;
			for(int i=1; i<=n; ++i) {
				for(int j=1; j<=n; ++j) {
					if(map[i][j] != 0) {
						continue;
					}
					if(goodLocY == 0 && goodLocX == 0) {
						goodLocY = i;
						goodLocX = j;
					}
					int likeCnt = 0;
					int emptyCnt = 0;
					boolean chk = false;
					for(int k=0; k<4; ++k) {
						nextY = i + dy[k];
						nextX = j + dx[k];
						if(nextY < 1 || nextX < 1 || nextY > n || nextX > n) {
							continue;
						}
						if(map[nextY][nextX] == 0) {
							++emptyCnt;
						} else {
							for(int l=1; l<=4; ++l) {
								if(map[nextY][nextX] == like[s][l]) {
									++likeCnt;
									break;
								}
							}
						}
					}
					if(likeCnt > maxLikeCnt) {
						chk = true;
					} else if(likeCnt < maxLikeCnt) {
						continue;
					}
					if(emptyCnt > maxEmptyCnt) {
						chk = true;
					} else if(!chk && emptyCnt < maxEmptyCnt) {
						continue;
					}
					if(i < goodLocY || goodLocY == 0) {
						chk = true;
					} else if (!chk && i > goodLocY) {
						continue;
					}
					if(j < goodLocX || goodLocX == 0) {
						chk = true;
					}
					if(chk) {
						maxLikeCnt = likeCnt;
						maxEmptyCnt = emptyCnt;
						goodLocY = i;
						goodLocX = j;
					}
				}
			}
			order[goodLocY][goodLocX] = s;
			map[goodLocY][goodLocX] = stu;
		}
		for(int i=1; i<=n; ++i) {
			for(int j=1; j<=n; ++j) {
				int happy = 1;
				for(int k=0; k<4; ++k) {
					nextY = i + dy[k];
					nextX = j + dx[k];
					if(nextY < 1 || nextX < 1 || nextY > n || nextX > n) {
						continue;
					}
					for(int l=1; l<=4; ++l) {
						if(map[nextY][nextX] == like[order[i][j]][l]) {
							happy *= 10;
							break;
						}
					}
				}
				ans += (happy / 10);
			}
		}
		bw.write(ans + "");
		bw.close();
	}
}
