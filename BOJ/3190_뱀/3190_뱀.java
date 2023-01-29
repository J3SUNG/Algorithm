package com.ssafy.test2;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+2][n+2];
		int k = sc.nextInt();
		int y, x;
		int l;
		int[] time;
		char[] d;
		int cnt = 0;
		int index = 0;
		int sy = 1;
		int sx = 1;
		int sd = 0;
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		Queue<Integer> qy = new LinkedList();
		Queue<Integer> qx = new LinkedList();
				
		for(int i=0; i<=n+1; ++i) {
			for(int j=0; j<=n+1; ++j) {
				if(i==0 || j==0 || i==n+1 || j==n+1) {
					arr[i][j] = 2;	// 0 공간, 1 사과, 2 벽
				} else {
					arr[i][j] = 0;					
				}
			}
		}
		
		for(int i=0; i<k; ++i) {
			y = sc.nextInt();
			x = sc.nextInt();
			arr[y][x] = 1;
		}
		l = sc.nextInt();
		time = new int[l];
		d = new char[l];
		for(int i=0; i<l; ++i) {
			time[i] = sc.nextInt();
			d[i] = sc.next().charAt(0);
		}
		
		while(true) {
			qy.add(sy);
			qx.add(sx);
			arr[sy][sx] = 2;
			if(index < time.length && cnt == time[index]) {
				if(d[index] == 'D') {
					sd = (sd + 1) % 4;
				} else if(d[index] == 'L') {
					sd = (sd + 4 - 1) % 4;
				}
				++index;
			}
			if(arr[sy + dy[sd]][sx + dx[sd]] == 2) {
				System.out.println(cnt + 1);
				return;
			} else if(arr[sy + dy[sd]][sx + dx[sd]] == 0) {
				y = qy.poll();
				x = qx.poll();
				arr[y][x] = 0;
			}
			++cnt;
			sy += dy[sd];
			sx += dx[sd];
		}
	}
}