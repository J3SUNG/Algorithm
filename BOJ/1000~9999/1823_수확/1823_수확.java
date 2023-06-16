import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n][n];
				
		for(int i=0; i<n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}					
		
		bw.write(func(0, n-1, 1) + "");
		bw.close();
	}
	public static int func(int left, int right, int cnt) {
		if(left > right) {
			return 0;
		}
		if(dp[left][right] != 0) {
			return dp[left][right];
		}
		
		dp[left][right] = Math.max(func(left+1, right, cnt+1) + arr[left] * cnt, func(left, right-1, cnt+1) + arr[right] * cnt);
		return dp[left][right];
	}
}
