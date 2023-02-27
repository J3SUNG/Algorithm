import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		int[][] map = new int[102][102];   // 흰색 천
		int[] dy = {0 ,1, 0, -1}; // 상하좌우 y
		int[] dx = {1, 0, -1, 0}; // 상하좌우 x
		for(int c=0; c<n; ++c) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a =  Integer.parseInt(st.nextToken());
			int b =  Integer.parseInt(st.nextToken());
			
			for(int i=0; i<=100; ++i) {
				for(int j=0; j<=100; ++j) {
					if(a <= i && i < a + 10 && b <= j && j < b + 10) {  // 스카프가 있으면 1
						map[i][j] = 1;
					}
				}
			}
		}
		for(int i=0; i<=101; ++i) {
			for(int j=0; j<=101; ++j) {
				if(map[i][j] > 0 ) { // 스카프가 있는 경우
					continue;
				}
				for(int k=0; k<4; ++k) { // 상하좌우 탐색
					int nextY = i + dy[k];
					int nextX = j + dx[k];
					if(nextY <= 0 || nextX <= 0 || nextY > 101 || nextX > 101) { //범위 벗어난 경우
						continue;
					}
					if(map[nextY][nextX] > 0) { // 빈 곳과 스카프가 인접한 경우
						++ans;
					}
				}
			}
		}
		bw.write(ans + "");
		bw.close();
	}
}