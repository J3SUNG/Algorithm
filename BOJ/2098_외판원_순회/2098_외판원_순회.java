import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int ans;
  static int[][] map;
  static int[][] dp;
  static int INF = 987654321;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    map = new int[n][n];
    dp = new int[1 << n][n];

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    ans = TSP(0, (1 << 0)); // 위치, bit

    bw.write(ans + "");
    bw.close();
  }

  public static int TSP(int loc, int bit) {
    if (bit == (1 << n) - 1) {
      if (map[loc][0] > 0) {
        return map[loc][0];
      }
      return INF;
    }

    if (dp[bit][loc] > 0) {
      return dp[bit][loc];
    }
    dp[bit][loc] = INF;

    for (int i = 0; i < n; ++i) {
      if ((bit & (1 << i)) == 0 && map[loc][i] > 0) { // 방문 안 한 경우
        dp[bit][loc] = Math.min(dp[bit][loc], TSP(i, bit | (1 << i)) + map[loc][i]);
      }
    }

    return dp[bit][loc];
  }
}