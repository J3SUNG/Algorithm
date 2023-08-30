import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st = null;
  static int testcase;
  static long n;
  static PriorityQueue<Long> pq;
  static long result;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void simulation() throws Exception {
    testcase = Integer.parseInt(br.readLine());

    for (int t = 1; t <= testcase; ++t) {
      init();
      calc();
      print();
    }

    bw.close();
  }

  public static void init() throws Exception {
    n = Long.parseLong(br.readLine());
    result = 1;
    pq = new PriorityQueue<Long>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      pq.add(Long.parseLong(st.nextToken()));
    }
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
  }

  public static void calc() throws Exception {
    while (pq.size() > 1) {
      long a = pq.poll();
      long b = pq.poll();

      result *= (a * b) % 1_000_000_007;
      result %= 1_000_000_007;
      pq.add(a * b);
    }
  }
}