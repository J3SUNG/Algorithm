package com.ssafy.test2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test7 {
	static int ans = 0;
	static int n;
	static int m;
	static int d;
	static int[][] map;
	static int[][] enemy;
	static int enemySize;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		enemy = new int[n * m][3];
		enemySize = 0;
		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					enemy[enemySize][0] = i;
					enemy[enemySize][1] = j;
					++enemySize;
				}
			}
		}
		for (int i = 0; i < m; ++i) {
			DFS(i, (1 << i), 1);
		}
		bw.write(ans + "\n");
		bw.close();
	}
	public static void Simulation(int bit, int[][] newMap) {
		int[] arrow = new int[3];
		int sum = 0;
		int c = 0;
		for (int i = 0; i < m; ++i) {
			if ((bit & (1 << i)) != 0) {
				arrow[c] = i;
				++c;
			}
		}
		for (int i = 0; i < enemySize; ++i) {
			enemy[i][2] = 0; 
		}
		for (int i = 1; i <= n; ++i) {
			for (int j = 0; j < 3; ++j) {
				int y = n - i;
				int x = arrow[j];
				int ti = -1;
				int tx = 987654321;
				int td = 987654321;
				for (int k = 0; k < enemySize; ++k) {
					if (enemy[k][0] <= y) {
						int dist = Math.abs(enemy[k][0] - y) + Math.abs(enemy[k][1] - x);
						if (dist < d && dist <= td && (enemy[k][2] == i || enemy[k][2] == 0)) {
							if (dist < td || tx > enemy[k][1]) {
								tx = enemy[k][1];
								ti = k;
								td = dist;
							}
						}
					}
				}
				if(ti > -1) {
					enemy[ti][2] = i;
				}
			}
		}
		for (int i = 0; i < enemySize; ++i) {
			if (enemy[i][2] != 0) {
				++sum;
			}
		}
		ans = Math.max(ans, sum);
	}
	public static void copy(int[][] map, int[][] copyMap) {
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
	public static void DFS(int index, int bit, int cnt) {
		if (cnt == 3) {
			int[][] copyMap = new int[n][m];
			copy(map, copyMap);
			Simulation(bit, copyMap);
			return;
		}
		for (int i = index + 1; i < m; ++i) {
			if ((bit & (1 << i)) == 0) {
				DFS(i, (bit | (1 << i)), cnt + 1);
			}
		}
	}
}