import java.util.Scanner;

public class Main{	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s;
		int[][] arr = new int[n+2][n+2];
		int ans = 0;
		for(int i=1; i<=n; ++i) {
			s = sc.next();
			for(int j=0; j<n; ++j) {
				if(s.charAt(j) == 'C') {
					arr[i][j+1] = 1;
				} else if(s.charAt(j) == 'P') {
					arr[i][j+1] = 2;
				} else if(s.charAt(j) == 'Z') {
					arr[i][j+1] = 3;
				} else if(s.charAt(j) == 'Y') {
					arr[i][j+1] = 4;
				}
			}
		}
		for(int i=1; i<=n; ++i) {
			for(int j=1; j<=n; ++j) {
				if(arr[i+1][j] != 0) {
					swap(arr, i, j, i+1, j);				
					ans = Math.max(ans, find(arr, arr[i][j], i, j));
					ans = Math.max(ans, find(arr, arr[i+1][j], i+1, j));
					swap(arr, i, j, i+1, j);
				}
				if(arr[i][j+1] != 0) {
					swap(arr, i, j, i, j+1);
					ans = Math.max(ans, find(arr, arr[i][j], i, j));
					ans = Math.max(ans, find(arr, arr[i][j+1], i, j+1));
					swap(arr, i, j, i, j+1);
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void swap(int[][] arr, int ai, int aj, int bi, int bj) {
		int tmp;
		tmp = arr[ai][aj];
		arr[ai][aj] = arr[bi][bj];
		arr[bi][bj] = tmp;
	}
	public static int moveFind(int[][] arr, int num, int y, int x, int d, int c) {
		if(d == 0) {
			x += -1;
		} else if(d == 1) {
			x += 1;
		} else if(d == 2) {
			y += -1;
		} else if(d == 3) {
			y += 1;
		}
		if(num == arr[y][x]) {
			c = moveFind(arr, num, y, x, d, c + 1);
		}
		return c;
	}
	public static int find(int[][] arr, int num, int y, int x){
		int ans = 0;
		ans = Math.max(ans, moveFind(arr, num, y, x, 0, 0) + moveFind(arr, num, y, x, 1, 0) + 1);
		ans = Math.max(ans, moveFind(arr, num, y, x, 2, 0) + moveFind(arr, num, y, x, 3, 0) + 1);
		return ans;
	}
}
