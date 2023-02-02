import java.util.Scanner;

public class Main {
	static int ans = 0;  
  static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
  static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[4][4];
		int[][] dir = new int[4][4];
		int[] orderY = new int[16];
		int[] orderX = new int[16];		
		for(int i=0; i<4; ++i) {
			for(int j=0; j<4; ++j) {
				map[i][j] = sc.nextInt();
				orderY[map[i][j] - 1] = i;
				orderX[map[i][j] - 1] = j;
				dir[i][j] = sc.nextInt() - 1;
			}
		}
		dfs(0, 0, map, dir, 0, orderY, orderX);		
		
		System.out.println(ans);
	}	
	public static void dfs(int y, int x, int[][] map, int[][] dir, int sum, int[] orderY, int[] orderX) {
		int nextY = y;
		int nextX = x;
		int[][] newMap = new int[4][4];
		int[][] newDir = new int[4][4];		
		int[] newOrderY = new int[16];
		int[] newOrderX = new int[16];
		for(int i=0; i<4; ++i) {
			for(int j=0; j<4; ++j) {
				newMap[i][j] = map[i][j];
				newDir[i][j] = dir[i][j];
				newOrderY[i*4+j] = orderY[i*4+j];
				newOrderX[i*4+j] = orderX[i*4+j];
			}
		}
		sum += newMap[y][x];
		newOrderY[newMap[y][x] - 1] = -1;
		newOrderX[newMap[y][x] - 1] = -1;
		newMap[y][x] = -1;
		move(y, x, newMap, newDir, newOrderY, newOrderX);
		newMap[y][x] = 0;
		while(true) {
			nextY += dy[newDir[y][x]];
			nextX += dx[newDir[y][x]];
			if(nextY < 0 || nextX < 0 || nextY >= 4 || nextX >= 4) {
				break;
			}
			if(newMap[nextY][nextX] == 0) {
				continue;
			}
			dfs(nextY, nextX, newMap, newDir, sum, newOrderY, newOrderX);
		}
		ans = Math.max(ans, sum);
	}
	public static void move(int y, int x, int[][] map, int[][] dir, int[] orderY, int[] orderX) {
		int oy, ox;
		int noy, nox;
		int tmp;
		for(int i=0; i<16; ++i) {
			oy = orderY[i];
			ox = orderX[i];
			if(orderY[i] < 0 || map[oy][ox] <= 0) {
				continue;
			}
			for(int j=0; j<8; ++j) {
				noy = oy + dy[(dir[oy][ox] + j) % 8];
				nox = ox + dx[(dir[oy][ox] + j) % 8];
				if(noy < 0 || nox < 0 || noy >= 4 || nox >= 4) {
					continue;
				}
				if(map[noy][nox] == -1) {
					continue;
				}
				orderY[i] = noy;
				orderX[i] = nox;
				if(map[noy][nox] > 0) {
					orderY[map[noy][nox] - 1] = oy;
					orderX[map[noy][nox] - 1] = ox;
				}
				tmp = map[noy][nox];
				map[noy][nox] = map[oy][ox];
				map[oy][ox] = tmp;
				tmp = dir[noy][nox];
				dir[noy][nox] = (dir[oy][ox] + j) % 8;
				dir[oy][ox] = tmp;
				break;
			}
		}
	}
}