import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
  static StringTokenizer st = null;
  static int n;
  static int testcase;
  static long[][] dp;
  static long result;
  static int MOD = 1_000_000_007;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void init() throws Exception {
    testcase = Integer.parseInt(br.readLine());
    dp = new long[5001][2502];
    dp[0][0] = 1;
  }

  public static void simulation() throws Exception {
    init();
    calc();

    for (int i = 0; i < testcase; ++i) {
      int num = Integer.parseInt(br.readLine());
      print(num);
    }

    bw.close();
  }

  public static void calc() throws Exception {
    for (int i = 1; i <= 5000; ++i) {
      for (int j = 0; j < 2501; ++j) {
        if (j > 0) {
          dp[i][j] += dp[i - 1][j - 1] % MOD;
        }
        dp[i][j] += dp[i - 1][j + 1] % MOD;
        dp[i][j] %= MOD;
      }
    }
  }

  public static void print(int num) throws Exception {
    bw.write(dp[num][0] + "\n");
  }
}