import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int n;
  static int m;
  static int result;
  static int[] arr;
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

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[m];
    MAX = 987654321;
    result = MAX;

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int bit = 0;

      for (int j = 0; j < num; ++j) {
        int temp = Integer.parseInt(st.nextToken()) - 1;
        bit |= (1 << temp);
      }

      arr[i] = bit;
    }
  }

  public static void print() throws Exception {
    bw.write((result == MAX ? -1 : result) + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    for (int i = 0; i < m; ++i) {
      dfs(i, arr[i], 1);
    }
  }

  public static void dfs(int index, int bit, int cnt) throws Exception {
    if (cnt >= result) {
      return;
    }

    if (bit == (1 << n) - 1) {
      result = Math.min(result, cnt);
      return;
    }

    for (int i = index + 1; i < m; ++i) {
      dfs(i, bit | arr[i], cnt + 1);
    }
  }
}