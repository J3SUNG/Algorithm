import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> qy = new LinkedList<>();
		Queue<Integer> qx = new LinkedList<>();
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int[][] visit = new int[n][n];
		int[] dy = {0, 1, 0, -1};
		int[] dx = {1, 0, -1, 0};
		int[] ans = new int[n*n];
		int index = 0;
		
		for(int i=0; i<n; ++i) {
			String str = br.readLine();
			for(int j=0; j<n; ++j) {
				map[i][j] = str.charAt(j) == '0' ? 0 : 1;
			}
		}
		for(int i=0; i<n; ++i) {
			for(int j=0; j<n; ++j) {
				if(visit[i][j] == 1 || map[i][j] == 0) {
					continue;
				}
				qy.add(i);
				qx.add(j);
				visit[i][j] = 1;
				int num = 0;
				while(!qy.isEmpty()) {
					int y = qy.poll();
					int x = qx.poll();
					++num;
					for(int k=0; k<4; ++k) {
						int nextY = y + dy[k];
						int nextX = x + dx[k];
						if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
							continue;
						}
						if(visit[nextY][nextX] == 1 || map[nextY][nextX] == 0) {
							continue;
						}
						qy.add(nextY);
						qx.add(nextX);
						visit[nextY][nextX] = 1;
					}
				}
				ans[index] = num;
				++index;
			}
		}		
		Arrays.sort(ans);
		bw.write(index + "\n");
		for(int i=0; i<index; ++i) {
			bw.write(ans[n*n-index+i] + "\n");
		}
		bw.close();
	}
}
