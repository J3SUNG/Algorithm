import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int result = 1_000_000_000;
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n + 1];
    int[] prefixSum = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
      prefixSum[i] = arr[i] + prefixSum[i - 1];
    }

    int left = 0;
    int right = 1_000_000_000;
    while (left <= right) {
      int mid = (left + right) / 2;
      int start = 0;
      int sum = 0;
      int cnt = 0;
      for (int i = 1; i <= n; ++i) {
        if (prefixSum[i] - prefixSum[start] > mid) {
          sum = Math.max(sum, prefixSum[i - 1] - prefixSum[start]);
          start = i - 1;
          ++cnt;
        }
      }
      sum = Math.max(sum, prefixSum[n] - prefixSum[start]);
      ++cnt;

      if (cnt > m) {
        left = mid + 1;
      } else if (cnt <= m) {
        result = Math.min(result, sum);
        right = mid - 1;
      }
    }

    bw.write(result + "\n");
    bw.close();
  }
}