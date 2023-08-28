import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int n;
  static int m;
  static int[] arr;
  static int result;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void init() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[m];

    for (int i = 0; i < m; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }
  }

  public static void printResult() throws Exception {
    bw.write(result + "");
    bw.close();
  }

  public static void binarySearch() throws Exception {
    int left = 1;
    int right = 1_000_000_000;

    while (left <= right) {
      int mid = (left + right) / 2;
      int cnt = 0;

      for (int i = 0; i < m; ++i) {
        cnt += arr[i] / mid;
        if (arr[i] % mid != 0) {
          ++cnt;
        }
      }

      if (cnt <= n) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    result = left;
  }

  public static void simulation() throws Exception {
    init();
    binarySearch();
    printResult();
  }
}