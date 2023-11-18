import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st = null;
  static int n;
  static boolean flag;

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
    flag = false;
  }

  public static void print() throws Exception {
    if (!flag) {
      bw.write("-1\n");
    }
    bw.close();
  }

  public static void calc() throws Exception {
    int start = 1;
    int end = 1;

    while (start <= end && end <= n) {
      int diff = end * end - start * start;
      if (diff == n) {
        bw.write(end + "\n");
        flag = true;
        ++start;
      } else if (diff < n) {
        ++end;
      } else {
        ++start;
      }
    }
  }
}