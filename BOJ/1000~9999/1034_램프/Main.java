import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int result = 0;
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k;
    int cnt = 0;
    String[] arr = new String[n];
    int[] zeroCnt = new int[n];
    String prev = "";

    for (int i = 0; i < n; ++i) {
      arr[i] = br.readLine();
    }

    Arrays.sort(arr);
    k = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (arr[i].charAt(j) == '0') {
          ++zeroCnt[i];
        }
      }

      if (!arr[i].equals(prev)) {
        cnt = 0;
      }

      prev = arr[i];

      if (zeroCnt[i] <= k && zeroCnt[i] % 2 == k % 2) {
        ++cnt;
        result = Math.max(result, cnt);
      }
    }

    bw.write(result + "\n");
    bw.close();
  }
}