import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
  static StringTokenizer st;
  static int n;
  static long result;
  static PriorityQueue<Long> pq;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void init() throws Exception {
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    pq = new PriorityQueue<>();
    st = new StringTokenizer(br.readLine());
    result = 0;

    for (int i = 0; i < n; ++i) {
      pq.add(Long.parseLong(st.nextToken()));
    }
  }

  public static void simulation() throws Exception {
    int testcase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testcase; ++i) {
      init();
      calc();
      print();
    }

    bw.close();
  }

  public static void calc() throws Exception {
    while (pq.size() > 1) {
      long a = pq.poll();
      long b = pq.poll();
      result += a + b;

      pq.add(a + b);
    }
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
  }
}