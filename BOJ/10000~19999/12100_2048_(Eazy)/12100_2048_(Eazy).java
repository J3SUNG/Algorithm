import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int n;
	static int[][] map;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	static int max = 5;
	static int maxValue = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<4; ++i) {
			DFS(map, i, 0); // 방향, cnt
		}
		
		System.out.println(maxValue);
	}
	public static void DFS(int[][] map, int dir, int cnt) {
		int[][] newMap = new int[n][n];
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				newMap[i][j] = map[i][j];
				if(max == cnt) {
					maxValue = Math.max(maxValue,  newMap[i][j]);
				}
			}
		}
		if(max == cnt) {
			return;
		}
		moveMap(newMap, dir);
		
		for(int i=0; i<4; ++i) {
			DFS(newMap, i, cnt+1);
		}
	}
	public static void moveMap(int[][] newMap, int dir) {
		int num;
		int c;
		int arr[] = new int[n];
		switch(dir) {
			case 0: // 오른쪽
				for(int i=0; i<n; ++i) {
					num = 0;
					c = 0;
					for(int j=n-1; j>=0; --j) {
						if(newMap[i][j] == 0) {
							continue;
						}
						if(num == 0) {
							num = newMap[i][j];
							continue;
						}
						if(newMap[i][j] == num) {
							arr[c] = newMap[i][j] * 2;
							num = 0;
							++c;
						} else {
							arr[c] = num;
							num = newMap[i][j];
							++c;
						}
					}
					arr[c] = num;
					for(int j=0; j<n; ++j) {
						newMap[i][n-1-j] = arr[j];
						arr[j] = 0;
					}
				}
				break;
			case 1: // 아래
				for(int i=0; i<n; ++i) {
					num = 0;
					c = 0;
					for(int j=n-1; j>=0; --j) {
						if(newMap[j][i] == 0) {
							continue;
						}
						if(num == 0) {
							num = newMap[j][i];
							continue;
						}
						if(newMap[j][i] == num) {
							arr[c] = newMap[j][i] * 2;
							num = 0;
							++c;
						} else {
							arr[c] = num;
							num = newMap[j][i];
							++c;
						}
					}
					arr[c] = num;
					for(int j=0; j<n; ++j) {
						newMap[n-1-j][i] = arr[j];
						arr[j] = 0;
					}
				}
				break;
			case 2: // 왼쪽
				for(int i=0; i<n; ++i) {
					num = 0;
					c = 0;
					for(int j=0; j<n; ++j) {
						if(newMap[i][j] == 0) {
							continue;
						}
						if(num == 0) {
							num = newMap[i][j];
							continue;
						}
						if(newMap[i][j] == num) {
							arr[c] = newMap[i][j] * 2;
							num = 0;
							++c;
						} else {
							arr[c] = num;
							num = newMap[i][j];
							++c;
						}
					}
					arr[c] = num;					
					for(int j=0; j<n; ++j) {
						newMap[i][j] = arr[j];
						arr[j] = 0;
					}
				}
			break;
			case 3: // 위
				for(int i=0; i<n; ++i) {
					num = 0;
					c = 0;
					for(int j=0; j<n; ++j) {
						if(newMap[j][i] == 0) {
							continue;
						}
						if(num == 0) {
							num = newMap[j][i];
							continue;
						}
						if(newMap[j][i] == num) {
							arr[c] = newMap[j][i] * 2;
							num = 0;
							++c;
						} else {
							arr[c] = num;
							num = newMap[j][i];
							++c;
						}
					}
					arr[c] = num;
					for(int j=0; j<n; ++j) {
						newMap[j][i] = arr[j];
						arr[j] = 0;
					}
				}
				break;
		}
	}
}