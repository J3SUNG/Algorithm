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
          System.out.println(prefixSum[i] - prefixSum[start]);
          sum = Math.max(sum, prefixSum[i] - prefixSum[start]);
          start = i;
          ++cnt;
        }
        if (cnt > m) {
          sum = 1_000_000_000;
          break;
        }
      }
      System.out.println("HI");
      System.out.println(cnt + " " + sum + " " + mid);

      if (cnt > m) {
        left = mid + 1;
        continue;
      } else if (cnt < m) {
        right = mid - 1;
        continue;
      }

      if (result > sum) {
        result = sum;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    bw.write(result + "\n");
    bw.close();

  }
}