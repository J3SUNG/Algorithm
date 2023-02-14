import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[r+1][c+1];
		Queue<Shark> q = new LinkedList<>();
		Shark[] sharkSort = new Shark[m];
		Shark shark;
		
		for(int i=0; i<m; ++i) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken()); //y
			int sc = Integer.parseInt(st.nextToken()); //x
			int ss = Integer.parseInt(st.nextToken()); //속력
			int sd = Integer.parseInt(st.nextToken()); //방향
			int sz = Integer.parseInt(st.nextToken()); //크기
			if (sd == 3 || sd == 4) {
				ss = ss % (2 * (c - 1));
			}
			else if(sd == 1 || sd == 2) {
				ss = ss % (2 * (r - 1));
			}
			shark = new Shark(sr, sc, ss, sd, sz);
			map[sr][sc] = sz;
			sharkSort[i] = shark;
		}
		
		Arrays.sort(sharkSort, (o1, o2) -> -(o1.z-o2.z));
		for(int i=0; i<sharkSort.length; ++i) {
			q.add(sharkSort[i]);
		}
		
		for(int loc=1; loc<=c; ++loc) {
			int size = q.size();
			int catchShark = 0;
			for(int i=1; i<=r; ++i) {
				if(map[i][loc] != 0) {
					ans += map[i][loc];
					catchShark = map[i][loc];
					break;
				}
			}
			initMap(r, c, map);
			for(int s=0; s<size; ++s) {
				shark = q.poll();
				if(shark.z == catchShark) {
					continue;
				}
				if(shark.d == 1) { //위
					shark.r -= shark.s;
					if(shark.r <= 0) {
						shark.r = Math.abs(shark.r-2);
						shark.d = 2;
					}
					if(shark.r > r) {
						shark.r = r - (shark.r - r);
						shark.d = 1;
					}
					if(shark.r <= 0) {
						shark.r = Math.abs(shark.r-2);
						shark.d = 2;
					}
				} else if(shark.d == 2) { //아래
					shark.r += shark.s;
					if(shark.r > r) {
						shark.r = r - (shark.r - r);
						shark.d = 1;
					}
					if(shark.r <= 0) {
						shark.r = Math.abs(shark.r-2);
						shark.d = 2;
					}
					if(shark.r > r) {
						shark.r = r - (shark.r - r);
						shark.d = 1;
					}
				} else if(shark.d == 3) { //오른쪽
					shark.c += shark.s;
					if(shark.c > c) {
						shark.c = c - (shark.c - c);
						shark.d = 4;
					}
					if(shark.c <= 0) {
						shark.c = Math.abs(shark.c-2);
						shark.d = 3;
					}
					if(shark.c > c) {
						shark.c = c - (shark.c - c);
						shark.d = 4;
					}
				} else if(shark.d == 4) { //왼쪽
					shark.c -= shark.s;
					if(shark.c <= 0) {
						shark.c = Math.abs(shark.c-2);
						shark.d = 3;
					}
					if(shark.c > c) {
						shark.c = c - (shark.c - c);
						shark.d = 4;
					}
					if(shark.c <= 0) {
						shark.c = Math.abs(shark.c-2);
						shark.d = 3;
					}
				}
				if(map[shark.r][shark.c] == 0) {
					q.add(shark);						
					map[shark.r][shark.c] = shark.z;
				}
			}
		}
		
		bw.write(ans + "");
		bw.close();
	}	
	public static void initMap(int r, int c, int[][] map) {
		for(int i=1; i<=r; ++i) {
			for(int j=1; j<=c; ++j) {
				map[i][j] = 0;
			}
		}
	}
	public static class Shark {
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}