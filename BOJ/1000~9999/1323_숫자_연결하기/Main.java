import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long n = Integer.parseInt(st.nextToken());
    long k = Integer.parseInt(st.nextToken());
    int result = 1;
    int[] check = new int[100001];
    long num = n % k;
    String s = Long.toString(n);
    long mul = (long) Math.pow(10, s.length());

    while (true) {
      if (num == 0) {
        break;
      }

      num = (n % k + (num * (mul % k)) % k) % k;

      ++result;
      if (check[(int) num] == 1) {
        result = -1;
        break;
      }

      check[(int) num] = 1;
    }

    bw.write(result + "\n");
    bw.close();
  }
}