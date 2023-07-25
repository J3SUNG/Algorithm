import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    long[][] arr = new long[n + 1][2];
    long result = 0;

    for (int i = 0; i < n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    arr[n][0] = arr[0][0];
    arr[n][1] = arr[0][1];

    long a = 0L;
    long b = 0L;
    for (int i = 0; i < n; ++i) {
      result += arr[i][0] * arr[i + 1][1] - arr[i][1] * arr[i + 1][0];
    }

    bw.write(String.format("%.1f", (Math.abs(result) / 2.0)) + "\n");
    bw.close();
  }
}