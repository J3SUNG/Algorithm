import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    int[] sum1 = new int[n];
    int[] sum2 = new int[n];
    int result = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    sum1[0] = arr[0];
    sum2[n - 1] = arr[n - 1];
    for (int i = 1; i < n; ++i) {
      sum1[i] = sum1[i - 1] + arr[i];
      sum2[n - 1 - i] = sum2[n - i] + arr[n - 1 - i];
    }

    for (int i = 1; i < n - 1; ++i) {
      result = Math.max(result, sum1[i] + sum2[i] - sum1[0] - sum2[n - 1]);
      result = Math.max(result, sum1[n - 1] + sum1[n - 1] - sum1[0] - arr[i] - sum1[i]);
      result = Math.max(result, sum2[0] + sum2[0] - sum2[n - 1] - arr[n - 1 - i] - sum2[n - 1 - i]);
    }

    bw.write(result + "\n");
    bw.close();
  }
}