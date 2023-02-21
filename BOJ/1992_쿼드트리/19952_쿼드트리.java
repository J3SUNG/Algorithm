import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static String ans = "";
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0; i<n; ++i) {
			String s = br.readLine(); 
			for(int j=0; j<n; ++j) {
				map[i][j] = s.charAt(j) == '0' ? 0 : 1;
			}
		}
		Func(0, 0, n);
		bw.write(ans);
		bw.close();
	}
	public static void Func(int y, int x, int size) {
		int num = map[y][x]; 
		for(int i=0; i<size; ++i) {
			for(int j=0; j<size; ++j) {
				if(map[y+i][x+j] != num) {
					ans += "(";
					Func(y, x, size/2);
					Func(y, x+size/2, size/2);
					Func(y+size/2, x, size/2);
					Func(y+size/2, x+size/2, size/2);
					ans += ")";
					return;
				} 
			}
		}
		ans += num == 0 ? "0" : "1";
	}
}