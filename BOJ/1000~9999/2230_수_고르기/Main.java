import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    int result = 2_000_000_001;

    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    int left = 0;
    int right = 0;
    while (left <= right && right < n) {
      int num = Math.abs(arr[left] - arr[right]);
      if (num < m) {
        ++right;
      } else if (num > m) {
        result = Math.min(result, num);
        ++left;
      } else {
        result = Math.min(result, num);
        ++right;
        ++left;
      }
    }

    bw.write(result + "\n");
    bw.close();
  }
}