import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			long ans = 0;
			int n = Integer.parseInt(br.readLine());
			dp = new long[n + 1][n + 1];

			if (n == 0) {
				break;
			}

			ans = func(n - 1, 1);

			bw.write(ans + "\n");
		}
		bw.close();
	}

	public static long func(int pill, int half) {
		if (dp[pill][half] > 0) {
			return dp[pill][half];
		}

		if (pill == 0) {
			return 1;
		} else if (half == 0) {
			dp[pill][half] = func(pill - 1, half + 1);
		} else if (pill > 0 && half > 0) {
			dp[pill][half] += func(pill - 1, half + 1);
			dp[pill][half] += func(pill, half - 1);
		}
		return dp[pill][half];
	}
}