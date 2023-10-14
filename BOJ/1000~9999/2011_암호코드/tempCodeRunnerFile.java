import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static String s;
  static int[] dp;

  static int MAX;

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
    dp = new int[5001];

    dp[0] = 1;
    dp[1] = 1;
  }

  public static void print() throws Exception {
    bw.write(dp[s.length()] + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    for (int i = 2; i <= s.length(); ++i) {
      int num = Integer.parseInt(s.substring(i - 2, i));
      if (num >= 10 && num <= 26) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
      } else {
        dp[i] = dp[i - 1];
      }
    }
  }
}