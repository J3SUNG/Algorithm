import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long n = Long.parseLong(st.nextToken());
    long m = Long.parseLong(st.nextToken());
    long[] arr = new long[(int) n];
    long result = 1_000_000_000L * 1_000_000_000L;

    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    long left = 1;
    long right = 1_000_000_000L * 1_000_000_000L;
    while (left <= right) {
      long mid = (left + right) / 2;

      if (check(m, mid, arr)) {
        right = mid - 1;
        result = Math.min(result, mid);
      } else {
        left = mid + 1;
      }
    }

    bw.write(result + "\n");
    bw.close();
  }

  public static boolean check(long m, long mid, long arr[]) {
    for (int i = 0; i < arr.length; ++i) {
      m -= mid / arr[i];

      if (m <= 0) {
        return true;
      }
    }
    return false;
  }
}