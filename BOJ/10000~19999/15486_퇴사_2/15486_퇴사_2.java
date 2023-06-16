import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		int[] value = new int[n];
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken());

			time[i] = a;
			value[i] = b;
		}

		for (int i = n - 1; i >= 0; --i) {
			if (i + time[i] >= n) {
				dp[i] = dp[i + 1];
				continue;
			}
			dp[i] = Math.max(value[i] + dp[i + time[i] + 1], dp[i + 1]);
		}
		ans = dp[0];

		bw.write(ans + "\n");
		bw.close();
	}
}