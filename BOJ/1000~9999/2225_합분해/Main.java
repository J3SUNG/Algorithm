import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= n; ++i) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= m; ++i) {
      for (int j = 0; j <= n; ++j) {
        dp[i][j] = dp[i - 1][j];
        dp[i][j] %= 1_000_000_000;
        if (j < n) {
          dp[i - 1][j + 1] += dp[i - 1][j];
          dp[i - 1][j + 1] %= 1_000_000_000;
        }
      }
    }

    bw.write(dp[m][n] + "\n");
    bw.close();
  }
}
