import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[] move = new int[k];
		int[] dice = new int[6];
		int[] dy = {0, 0, -1, 1};
		int[] dx = {1, -1, 0, 0};
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; ++i) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<k; ++i) {
			int moveY = y + dy[move[i] - 1];
			int moveX = x + dx[move[i] - 1];
			int tmp;
			if(moveY < 0 || moveX < 0 || moveY >= n || moveX >= m) {
				continue;
			}
			y = moveY;
			x = moveX;
			if(move[i] == 1) { // 동쪽
				tmp = dice[0];
				dice[0] = dice[5];
				dice[5] = dice[2];
				dice[2] = dice[4];
				dice[4] = tmp;
			} else if (move[i] == 2) { // 서쪽
				tmp = dice[0];
				dice[0] = dice[4];
				dice[4] = dice[2];
				dice[2] = dice[5];
				dice[5] = tmp;
			} else if (move[i] == 3) { // 북쪽
				tmp = dice[3];
				dice[3] = dice[2];
				dice[2] = dice[1];
				dice[1] = dice[0];
				dice[0] = tmp;				
			} else if (move[i] == 4) { // 남쪽
				tmp = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = tmp;
			}
			if(map[y][x] == 0) {
				map[y][x] = dice[0];
			} else {
				dice[0] = map[y][x];
				map[y][x] = 0;				
			}
			bw.write(String.valueOf(dice[2]));
			bw.write("\n");
		}
		bw.flush();
	}
}