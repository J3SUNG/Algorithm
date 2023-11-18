import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st = null;
  static int n, m, r;
  static int[] arr;
  static int[][] map;
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
    r = Integer.parseInt(st.nextToken());
    result = 0;
    arr = new int[n + 1];
    map = new int[n + 1][n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i <= n; ++i) {
      for (int j = 0; j <= n; ++j) {
        map[i][j] = i == j ? 0 : 987654321;
      }
    }

    for (int i = 1; i <= r; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());

      map[a][b] = l;
      map[b][a] = l;
    }
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    for (int k = 1; k <= n; ++k) {
      for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
          map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
        }
      }
    }

    for (int i = 1; i <= n; ++i) {
      int sum = 0;
      for (int j = 1; j <= n; ++j) {
        if (map[i][j] <= m) {
          sum += arr[j];
        }
      }
      result = Math.max(result, sum);
    }
  }
}