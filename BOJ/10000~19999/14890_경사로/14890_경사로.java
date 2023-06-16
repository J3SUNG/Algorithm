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
		int l = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		int ans = 0;
		boolean down = false;
		boolean chk = false;
		
		for(int i=0; i<n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; ++i) {
			int cnt = 0;
			int compare = map[i][0];
			down = false;
			chk = false;
			for(int j=0; j<n; ++j) {
				if(compare == map[i][j]) {
					++cnt;
					if((cnt >= l-1) && down) {
						down = false;
						cnt = 0;
					}
				} else if(compare == map[i][j] + 1) { //down
					if(l!=1 && down) {
						chk = true;
						break;						
					}
					cnt = 0;
					compare = map[i][j];
					down = true;
				} else if(compare == map[i][j] - 1) { //up
					if(down) {
						chk = true;
						break;
					}
					if(l!=1 && cnt < l) {
						chk = true;
						break;
					}
					compare = map[i][j];
					cnt = 1;
				} else {
					chk = true;
					break;
				}
			}			
			if(!chk && (!down || l == 1)) {
				++ans;
			}
		}
		for(int j=0; j<n; ++j) {
			int cnt = 0;
			int compare = map[0][j];
			down = false;
			chk = false;
			for(int i=0; i<n; ++i) {
				if(compare == map[i][j]) {
					++cnt;
					if((cnt >= l-1) && down) {
						down = false;
						cnt = 0;
					}
				} else if(compare == map[i][j] + 1) { //down
					if(l!=1 && down) {
						chk = true;
						break;						
					}
					cnt = 0;
					compare = map[i][j];
					down = true;
				} else if(compare == map[i][j] - 1) { //up
					if(down) {
						chk = true;
						break;
					}
					if(l!=1 && cnt < l) {
						chk = true;
						break;
					}
					compare = map[i][j];
					cnt = 1;
				} else {
					chk = true;
					break;
				}
			}			
			if(!chk && (!down || l == 1)) {
				++ans;
			}
		}
		System.out.println(ans);
	}
}