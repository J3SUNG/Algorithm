import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int goodSum = 2_000_000_001;
    int goodLeft = 0;
    int goodRight = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int left = 0;
    int right = n - 1;
    while (left < right) {
      int sum = Math.abs(arr[left] + arr[right]);

      if (goodSum > sum) {
        goodSum = sum;
        goodLeft = left;
        goodRight = right;
      }

      if (arr[left] + arr[right] > 0) {
        --right;
      } else {
        ++left;
      }
    }

    bw.write(arr[goodLeft] + " " + arr[goodRight] + "\n");
    bw.close();
  }
}