import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int MOD = 1_000_000_007;
    long result = 0;
    long[] arr = new long[3];
    String s = br.readLine();

    for (int i = 0; i < n; ++i) {
      if (s.charAt(i) == 'W') {
        ++arr[0];
        arr[0] %= MOD;
      } else if (s.charAt(i) == 'H') {
        arr[1] += arr[0];
        arr[1] %= MOD;
      } else if (s.charAt(i) == 'E') {
        result += arr[2];
        arr[2] *= 2;
        arr[2] += arr[1];
        arr[2] %= MOD;
      }
      result %= MOD;
    }

    bw.write(result + "\n");
    bw.close();
  }
}