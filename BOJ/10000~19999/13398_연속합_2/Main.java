import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int n;
  static int result;
  static int MIN;
  static int[] arr;
  static int[] sum;
  static int dp[][];

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

    MIN = -987654321;
    result = MIN;
    n = Integer.parseInt(br.readLine());
    arr = new int[n + 1];
    st = new StringTokenizer(br.readLine());
    dp = new int[n + 1][2];
    dp[0][0] = MIN;
    dp[0][1] = MIN;

    for (int i = 1; i <= n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    for (int i = 1; i <= n; ++i) {
      dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
      dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
      result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
    }
  }
}