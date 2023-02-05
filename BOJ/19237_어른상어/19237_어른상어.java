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
	static int[][] sharks;
	static int[][][] sharkMove;
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int bit = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n + 1][n + 1];
		time = new int[n + 1][n + 1];
		sharks = new int[m + 1][3];
		sharkMove = new int[m + 1][5][4];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());

				if (num > 0) {
					sharks[num][0] = i;
					sharks[num][1] = j;
					sharks[num][2] = 0;
					time[i][j] = k;
					map[i][j] = n;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++)
			sharks[i][2] = Integer.parseInt(st.nextToken());

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
			if(bit == (1<<m+1)-4) {
				return ans;
			}

			if (ans >= 1000) {
				return -1;
			}

			int[][] tmp = new int[n + 1][n + 1];

			for (int i = 1; i <= m; i++) {

				if ((bit & (1<<i)) == 0) { // 상어가 경계 안에 있다면
					move(tmp, i);
				}
			}

			// 냄새 유효기간 하나씩 줄이기
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (time[i][j] > 0)
						time[i][j]--;

					if (time[i][j] == 0)
						map[i][j] = 0;
				}
			}

			// 이동후의 상어 위치의 냄새 정보와 유효기간 초기화하기
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

		// 1-1. 높은 우선순위부터 차례대로 탐색
		for (int i = 0; i < 4; i++) {
			d = sharkMove[index][sharks[index][2]][i];
			y = sharks[index][0] + dy[d];
			x = sharks[index][1] + dx[d];

			// 경계를 벗어나지 않으면서, 냄새가 없는 곳을 찾으면 break로 빠져나옴
			if ((1 <= y && y <= n) && (1 <= x && x <= n) && map[y][x] == 0) {
				chk = true;
				break;
			}
		}

		// 1-2. 냄새가 없는 곳이 없는 경우
		if (!chk) {
			for (int i = 0; i < 4; i++) {
				d = sharkMove[index][sharks[index][2]][i];
				y = sharks[index][0] + dy[d];
				x = sharks[index][1] + dx[d];

				if ((1 <= y && y <= n) && (1 <= x && x <= n) && map[y][x] == m)
					break;
			}
		}

		if (tmp[y][x] == 0) {

			tmp[y][x] = m;
			sharks[index][0] = y;
			sharks[index][1] = x;
			sharks[index][2] = d;
		} else {
			bit = bit | (1 << index);
		}
	}
}