package com.ssafy.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test21 {
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static int[][] time;
	static int[][] sharks;
	static int[][][] sharkMove; // 상어, 방향, 우선순위
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int bit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		time = new int[n][n];
		sharks = new int[m][3];  // m, y,x,d
		sharkMove = new int[m][4][4];  // m, 방향, 우선순위
		bit = 0;
		
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) {
					time[i][j] = k;
					sharks[map[i][j] - 1][0] = i;
					sharks[map[i][j] - 1][1] = j;
					sharks[map[i][j] - 1][2] = 0;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; ++i) {
			sharks[i][2] = Integer.parseInt(st.nextToken()) - 1;
		}
		for(int i=0; i<m; ++i) {
			for(int j=0; j<4; ++j) {
				st = new StringTokenizer(br.readLine());
				for(int l=0; l<4; ++l) {
					sharkMove[i][j][l] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
		}
		int ans = 0;
		while(true) {
			if(bit == (1<<m)-2) {
				System.out.println(ans);
				return;
			}
			if(ans >= 1000) {
				System.out.println(-1);
				return;
			}
			
			int[][] temp = new int[n][n];
			for(int i=0; i<m; ++i) {
				if((bit & (1<<i)) == 0) {
					move(temp, i);
				}
			}
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					if(time[i][j] > 0) {
						--time[i][j];
						if(time[i][j] == 0) {
							map[i][j] = 0;
						}
					}
				}
			}
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					if(temp[i][j] > 0) {
						time[i][j] = k;
						map[i][j] = temp[i][j];
					}
				}
			}
			++ans;
		}		
	}
	public static void move(int[][] temp, int index) {
		int y = 0;
		int x = 0;
		int d = 0;
		boolean chk = false;
		
		for(int i=0; i<4; ++i) {
			d = sharkMove[index][sharks[index][2]][i];
			y = sharks[index][0] + dy[d];
			x = sharks[index][1] + dx[d];
			if(y < 0 || x < 0 || y >= n || x >= n) {
				continue;
			}			
			if(map[y][x] == 0) {	// 빈 공간이면 이동
				chk = true;
				break;
			}
		}
		if(!chk) {
			for(int i=0; i<4; ++i) {
				d = sharkMove[index][sharks[index][2]][i];
				y = sharks[index][0] + dy[d];
				x = sharks[index][1] + dx[d];
				if(y < 0 || x < 0 || y >= n || x >= n) {
					continue;
				}		
				if(map[y][x] == index + 1) {  // 자신의 냄새인 곳이면 이동
					break;
				}
			}
		}
		if(temp[y][x] == 0) {
			temp[y][x] = index + 1;
			sharks[index][0] = y;
			sharks[index][1] = x;
			sharks[index][2] = d;
		} else {
			bit = bit | (1 << index);
		}
	}
}