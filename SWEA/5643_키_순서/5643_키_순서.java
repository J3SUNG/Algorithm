import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int ts = Integer.parseInt(br.readLine());

    for (int t = 1; t <= ts; ++t) {
      int ans = 0;
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      boolean[][] map = new boolean[n + 1][n + 1];

      for (int i = 1; i <= m; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        map[a][b] = true;
      }

      for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
          if (i == j) {
            continue;
          }
          for (int k = 1; k <= n; ++k) {
            if (i == k || j == k) {
              continue;
            }
            if (map[j][i] && map[i][k]) {
              map[j][k] = true;
            }
          }
        }
      }

      for (int i = 1; i <= n; ++i) {
        int cnt = 0;
        for (int j = 1; j <= n; ++j) {
          if (i == j) {
            continue;
          }
          if (map[i][j]) {
            ++cnt;
          }
        }
        for (int j = 1; j <= n; ++j) {
          if (i == j) {
            continue;
          }
          if (map[j][i]) {
            ++cnt;
          }
        }
        if (cnt == n - 1) {
          ++ans;
        }
      }

      bw.write("#" + t + " " + ans + "\n");
    }
    bw.close();
  }
}