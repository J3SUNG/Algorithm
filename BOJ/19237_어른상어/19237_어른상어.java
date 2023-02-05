package com.ssafy.test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test21 {
	static int n, m, k;
	static int[][] map;
	static int[][] time;
	static int[][][] sharkMove;
	static Shark[] shark;
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		time = new int[n + 1][n + 1];
		shark = new Shark[m + 1];
		sharkMove = new int[m + 1][5][4];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());

				if (num > 0) {
					shark[num] = new Shark(i, j, 0);
					time[i][j] = k;
					map[i][j] = num;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++)
			shark[i].d = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int l = 0; l < 4; l++) {
					sharkMove[i][j][l] = Integer.parseInt(st.nextToken());
				}
			}
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int ans = 0;
		
		while (true) {
			int count = 0;
			for(int i=1; i<=m; ++i) {
				if(shark[i] != null) {
					++count;
				}
			}
			if(count == 1) {
				return ans;
			}
			
			if (ans >= 1000) {
				return -1;
			}

			int[][] tmp = new int[n + 1][n + 1];

			for (int i = 1; i <= m; i++) {

				if (shark[i] != null) {
					move(tmp, i);
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (time[i][j] > 0)
						time[i][j]--;

					if (time[i][j] == 0)
						map[i][j] = 0;
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (tmp[i][j] > 0) {
						time[i][j] = k;
						map[i][j] = tmp[i][j];
					}
				}
			}
			ans++;
		}
	}

	public static void move(int[][] tmp, int index) {

		int y = 0;
		int x = 0;
		int d = 0;
		boolean chk = false;

		for (int i = 0; i < 4; i++) {
			d = sharkMove[index][shark[index].d][i];
			y = shark[index].y + dy[d];
			x = shark[index].x + dx[d];

			if ((1 <= y && y <= n) && (1 <= x && x <= n) && map[y][x] == 0) {
				chk = true;
				break;
			}
		}

		if (!chk) {
			for (int i = 0; i < 4; i++) {
				d = sharkMove[index][shark[index].d][i];
				y = shark[index].y + dy[d];
				x = shark[index].x + dx[d];

				if ((1 <= y && y <= n) && (1 <= x && x <= n) && map[y][x] == index)
					break;
			}
		}

		if (tmp[y][x] == 0) {

			tmp[y][x] = index;
			shark[index].y = y;
			shark[index].x = x;
			shark[index].d = d;
		} else {
			shark[index] = null;
		}
	}
	static class Shark {

		int y, x, d;

		Shark(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}