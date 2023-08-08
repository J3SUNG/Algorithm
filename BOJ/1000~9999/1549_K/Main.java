import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    int n = Integer.parseInt(br.readLine());
    long[] arr = new long[n + 1];
    int k = 0;
    long min = Long.MAX_VALUE;

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; ++i) {
      int num = Integer.parseInt(st.nextToken());
      arr[i] = arr[i - 1] + num;
    }

    for (int i = 1; i <= n / 2; ++i) {
      for (int j = i; j <= n; ++j) {
        for (int l = j + i; l <= n; ++l) {
          long sub = Math.abs((arr[j] - arr[j - i]) - (arr[l] - arr[l - i]));
          if (sub <= min) {
            min = sub;
            k = i;
          }
        }
      }
    }

    bw.write(k + "\n");
    bw.write(min + "\n");
    bw.close();
  }
}