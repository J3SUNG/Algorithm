import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static String a;
  static String b;
  static int[][] dp;
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
    a = br.readLine();
    b = br.readLine();
    result = 0;
    dp = new int[a.length() + 1][b.length() + 1];
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    for (int i = 1; i <= a.length(); ++i) {
      for (int j = 1; j <= b.length(); ++j) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          result = Math.max(result, dp[i][j]);
        }
      }
    }
  }
}