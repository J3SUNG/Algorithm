import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int n;
	static int m;
	static int k;
	static int[][] arr;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][2];
		dp = new int[n + 1][m + 1][k + 1];

		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<=n; ++i) {
			for(int j=0; j<=m; ++j) {
				for(int l=0; l<=k; ++l) {
					dp[i][j][l] = -1;
				}
			}
		}
		ans = knapsack(0, m, k);

		bw.write(ans + "");
		bw.close();
	}

	public static int knapsack(int index, int b, int p) {
		if (index == n) {
			return 0;
		}
		if (dp[index][b][p] >= 0) {
			return dp[index][b][p];
		}
		if (arr[index+1][0] <= b && arr[index+1][1] <= p) {
			dp[index][b][p] = knapsack(index + 1, b - arr[index+1][0], p - arr[index+1][1]) + 1;
		}
		dp[index][b][p] = Math.max(dp[index][b][p], knapsack(index + 1, b, p));

		return dp[index][b][p];
	}
}
