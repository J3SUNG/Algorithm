import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long n = Long.parseLong(st.nextToken());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long c = Long.parseLong(st.nextToken());
    long d = Long.parseLong(st.nextToken());
    long result = Long.MAX_VALUE;

    if (b * c < d * a) {
      long temp;
      temp = a;
      a = c;
      c = temp;
      temp = b;
      b = d;
      d = temp;
    }

    for (int i = 0; i < c; ++i) {
      long index = (long) Math.ceil((double) (n - i * a) / c);

      if (index < 0) {
        index = 0;
      }
      result = Math.min(result, i * b + index * d);

      if (index == 0) {
        break;
      }
    }

    bw.write(result + "\n");
    bw.close();
  }
}