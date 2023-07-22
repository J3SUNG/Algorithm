import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int result;
  static int[] arr;
  static int[] visit;
  static int[] calc;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    result = 0;
    arr = new int[n];
    visit = new int[n];
    calc = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; ++i) {
      visit[i] = 1;
      dfs(i, 0);
      visit[i] = 0;
    }

    bw.write(result + "\n");
    bw.close();
  }

  public static void dfs(int index, int cnt) {
    calc[cnt] = arr[index];

    if (cnt == n - 1) {
      int sum = 0;

      for (int i = 1; i < n; ++i) {
        sum += Math.abs(calc[i - 1] - calc[i]);
      }
      result = Math.max(result, sum);

      return;
    }

    for (int i = 0; i < n; ++i) {
      if (visit[i] != 0) {
        continue;
      }

      visit[i] = 1;
      dfs(i, cnt + 1);
      visit[i] = 0;
    }
  }
}