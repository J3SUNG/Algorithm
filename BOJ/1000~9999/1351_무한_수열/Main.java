import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static long n;
  static long p;
  static long q;
  static long result;
  static HashMap<Long, Long> map;

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

    map = new HashMap<>();
    n = Long.parseLong(st.nextToken());
    p = Long.parseLong(st.nextToken());
    q = Long.parseLong(st.nextToken());
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    result = dp(n);
  }

  public static long dp(long n) throws Exception {
    if (n == 0) {
      return 1;
    }

    if (map.get(n) != null) {
      return map.get(n);
    }

    long a = n / p;
    long b = n / q;
    long value = 0;

    value += dp(a);
    value += dp(b);

    map.put(n, value);

    return value;
  }
}