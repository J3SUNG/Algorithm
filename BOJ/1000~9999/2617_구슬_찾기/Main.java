import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int n;
  static int m;
  static int half;
  static int[][] arr;
  static int result = 0;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void init() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n + 1][n + 1];
    half = (n / 2) + 1;

    for (int i = 1; i <= m; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a][b] = 1;
      arr[b][a] = -1;
    }
  }

  public static void simulation() throws Exception {
    init();
    floyd();
    compare();
    printResult();
  }

  public static void compare() throws Exception {
    int[] big = new int[n + 1];
    int[] small = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (arr[i][j] == 1) {
          ++big[i];
        }
        if (arr[i][j] == -1) {
          ++small[i];
        }
      }
    }

    for (int i = 1; i <= n; ++i) {
      if (big[i] >= half) {
        ++result;
      }
      if (small[i] >= half) {
        ++result;
      }
    }

  }

  public static void floyd() throws Exception {
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= n; ++j) {
        for (int k = 1; k <= n; ++k) {
          if (arr[k][i] != 0 && arr[j][i] == arr[i][k]) {
            arr[j][k] = arr[j][i];
          }
        }
      }
    }
  }

  public static void printResult() throws Exception {
    bw.write(result + "");
    bw.close();
  }
}