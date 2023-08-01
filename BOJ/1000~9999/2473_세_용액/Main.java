import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    long goodSum = Long.MAX_VALUE;
    int goodI = 0;
    int goodLeft = 0;
    int goodRight = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(arr);

    for (int i = 0; i < n - 2; ++i) {
      int left = i + 1;
      int right = n - 1;
      while (left < right) {
        long sum = arr[left] + arr[right];
        long sum2 = Math.abs(arr[i] + sum);
        if (goodSum > sum2) {
          goodSum = sum2;
          goodI = i;
          goodLeft = left;
          goodRight = right;
        }

        if (arr[i] + sum > 0) {
          --right;
        } else {
          ++left;
        }
      }
    }

    bw.write(arr[goodI] + " " + arr[goodLeft] + " " + arr[goodRight] + "\n");
    bw.close();
  }
}