import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ans = 0;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Pair[] arr = new Pair[n];
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Pair(a, b);
		}

		Arrays.sort(arr, (ta, tb) -> ta.a - tb.a);

		for (int i = 0; i < n; ++i) {
			for (int j = k; j > 0; --j) {
				if (j - arr[i].a < 0) {
					break;
				}
				dp[j] = Math.max(dp[j], dp[j - arr[i].a] + arr[i].b);
			}
		}

		for (int i = 0; i <= k; ++i) {
			ans = Math.max(ans, dp[i]);
		}

		bw.write(ans + "");
		bw.close();
	}

	public static class Pair {
		int a;
		int b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}