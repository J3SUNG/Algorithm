import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n+2][m+2];
		int[][] nmap = new int[n+2][m+2];
		int[][] space = new int[n*m][2];
		int[][] virus = new int[n*m][2];		
		int num;
		int vSize = 0;
		int sSize = 0;
		int cnt;
		int vNum = n*m;
		int y, x;
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0}; 
		Queue<Integer> qy = new LinkedList<>();
		Queue<Integer> qx = new LinkedList<>();
		
		for(int i=1; i<=n; ++i) {
			for(int j=1; j<=m; ++j) {
				num = sc.nextInt();
				if(num == 0) {
					num = 3;
					space[sSize][0] = i;
					space[sSize][1] = j;
					++sSize;
				} else if(num == 2) {
					virus[vSize][0] = i;
					virus[vSize][1] = j;
					++vSize;
				}
				map[i][j] = num;
			}
		}
		for(int i=0; i<sSize; ++i) {
			map[space[i][0]][space[i][1]] = 1;
			for(int j=i+1; j<sSize; ++j) {
				map[space[j][0]][space[j][1]] = 1;
				for(int k=j+1; k<sSize; ++k) {
					map[space[k][0]][space[k][1]] = 1;
					for(int l=0; l<vSize; ++l) {
						qy.add(virus[l][0]);
						qx.add(virus[l][1]);
					}
					for(int l=0; l<n+2; ++l) {
						for(int o=0; o<m+2; ++o) {
							nmap[l][o] = map[l][o];
						}
					}
					cnt = 0;
					while(!qy.isEmpty()) {
						y = qy.poll();
						x = qx.poll();
						++cnt;						
						if(cnt >= vNum) {
							qy.poll();
							qx.poll();
							continue;
						}						
						for(int l=0; l<4; ++l) {
							if(nmap[y + dy[l]][x + dx[l]] == 3) {
								nmap[y + dy[l]][x + dx[l]] = 1; 
								qy.add(y + dy[l]);
								qx.add(x + dx[l]);
							}
						}
					}
					vNum = Math.min(vNum, cnt);
					map[space[k][0]][space[k][1]] = 3;
				}
				map[space[j][0]][space[j][1]] = 3;
			}
			map[space[i][0]][space[i][1]] = 3;
		}
		System.out.println(sSize + vSize - vNum - 3);
	}
}
