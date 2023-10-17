import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static String s;
  static int[] dp;
  static int MOD;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void simulation() throws Exception {
    init();
    calc();
    print();
  }

  public static void init() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    st = new StringTokenizer(br.readLine());

    s = st.nextToken();
    dp = new int[5010];

    dp[0] = 1;
    dp[1] = 1;
    MOD = 1000000;
  }

  public static void print() throws Exception {
    bw.write(dp[s.length()] + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    if (s.charAt(0) == '0') {
      dp[s.length()] = 0;
      return;
    }

    for (int i = 2; i <= s.length(); ++i) {
      int num1 = Integer.parseInt(s.substring(i - 1, i));
      int num2 = Integer.parseInt(s.substring(i - 2, i));

      if (num1 > 0 && num1 < 10) {
        dp[i] = dp[i - 1];
      }
      if (num2 > 9 && num2 < 27) {
        dp[i] = (dp[i] + dp[i - 2]) % MOD;
      }
    }
  }
}