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
	static int ans = 987654321;
	static int[][] map;
	static Pair[] chicken;
	static Pair[] house;
	static int cCnt;
	static int hCnt;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		cCnt = 0;
		hCnt = 0;
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					++hCnt;
				} else if(map[i][j] == 2) {
					++cCnt;
				}
			}
		}
		
		chicken = new Pair[cCnt];
		house = new Pair[hCnt];
		visit = new boolean[cCnt];
		cCnt = 0;
		hCnt = 0;
		Pair p;
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				if(map[i][j] == 1) {
					p = new Pair(i, j);
					house[hCnt] = p;
					++hCnt;
				} else if (map[i][j] == 2) {
					p = new Pair(i, j);
					chicken[cCnt] = p;
					++cCnt;
				}
			}
		}
		for(int i=0; i<cCnt; ++i) {
			visit[i] = true;
			DFS(i, 1);
			visit[i] = false;
		}
		System.out.println(ans);
	}
	static void DFS(int index, int cnt) {
		if(cnt == m) {
			int totalDist = 0;
			for(int i=0; i<house.length; ++i) {
				int cthDist = 987654321;
				for(int j=0; j<chicken.length; ++j) {
					int num = 0;
					if(visit[j]) {
						num += Math.abs(house[i].y - chicken[j].y);
						num += Math.abs(house[i].x - chicken[j].x);
						cthDist = Math.min(cthDist, num);
					}
				}
				totalDist += cthDist;
			}
			ans = Math.min(ans, totalDist);
		}
		for(int i=index+1; i<cCnt; ++i) {
			visit[i] = true;
			DFS(i, cnt + 1);
			visit[i] = false;
		}
	}
	static class Pair{
		public int y, x;
		Pair(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}