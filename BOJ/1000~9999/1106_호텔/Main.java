import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st = null;
  static int n, m;
  static int[][] arr;
  static int[] dp;
  static int result;

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
    m = Integer.parseInt(st.nextToken());
    result = 987654321;
    arr = new int[m + 1][2];
    dp = new int[n + 100];

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    for (int j = 1; j < n + 100; ++j) {
      dp[j] = 987654321;
    }
  }

  public static void print() throws Exception {
    bw.write(result + " ");
    bw.close();
  }

  public static void calc() throws Exception {
    for (int i = 0; i < m; ++i) {
      for (int j = arr[i][1]; j < n + 100; ++j) {
        dp[j] = Math.min(dp[j], dp[j - arr[i][1]] + arr[i][0]);
      }
    }

    for (int i = n; i < n + 100; ++i) {
      result = Math.min(result, dp[i]);
    }
  }
}