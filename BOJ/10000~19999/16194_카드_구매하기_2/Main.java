import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n + 1];
    int[] calc = new int[n + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
      calc[i] = 987654321;
    }

    for (int i = 1; i <= n; ++i) {
      for (int j = 0; i + j <= n; ++j) {
        calc[i + j] = Math.min(calc[j + i], calc[j] + arr[i]);
      }
    }

    bw.write(calc[n] + "\n");
    bw.close();
  }
}