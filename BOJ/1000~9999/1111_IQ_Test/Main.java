import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int n;
  static int result;
  static int[] arr;

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

    result = 0;
    n = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    arr = new int[n];

    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
  }

  public static void print() throws Exception {
    bw.close();
  }

  public static void calc() throws Exception {
    if (n == 1) {
      bw.write("A\n");
    } else if (n == 2) {
      if (arr[0] == arr[1]) {
        bw.write(arr[0] + "\n");
      } else {
        bw.write("A\n");
      }
    } else {
      int a = 0;
      int b = 0;
      int x = arr[1] - arr[0];
      int y = arr[2] - arr[1];
      if (x != 0) {
        a = y / x;
      }
      b = arr[1] - arr[0] * a;

      for (int i = 1; i < n; ++i) {
        if (arr[i] != (arr[i - 1] * a + b)) {
          bw.write("B\n");
          return;
        }
      }
      bw.write(arr[n - 1] * a + b + "\n");
    }
  }
}