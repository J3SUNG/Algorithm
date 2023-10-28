import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  static int n, k;
  static int result;
  static int[][] back;
  static int[] dp;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void simulation() throws Exception {
    init();
    calc();
    print();
  }

  public static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    back = new int[k + 1][2];
    dp = new int[n + 1];
    result = 0;

    for (int i = 0; i < k; ++i) {
      st = new StringTokenizer(br.readLine());
      back[i][0] = Integer.parseInt(st.nextToken());
      back[i][1] = Integer.parseInt(st.nextToken());
    }
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    for (int i = 0; i < k; ++i) {
      for (int j = n; j >= back[i][1]; --j) {
        dp[j] = Math.max(dp[j], dp[j - back[i][1]] + back[i][0]);
      }
    }

    for (int i = 0; i <= n; ++i) {
      result = Math.max(result, dp[i]);
    }
  }
}