import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int n;
  static int[][] map;
  static int[][] visit;
  static int result;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    visit = new int[n][n];
    result = 0;

    for (int i = 0; i < n; ++i) {
      String s = br.readLine();
      for (int j = 0; j < n; ++j) {
        if (s.charAt(j) == '-') {
          map[i][j] = 0;
        } else {
          map[i][j] = 1;
        }
        visit[i][j] = -1;
      }
    }

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (map[i][j] == 1 && visit[i][j] == -1) {
          dfs(i, j, 0);
        }
      }
    }

    bw.write(result + "\n");
    bw.close();
  }

  public static void dfs(int y, int x, int cnt) {
    int[] dy = { 0, 1, -1, 1, -1, 0 };
    int[] dx = { -1, -1, 0, 0, 1, 1 };

    visit[y][x] = cnt;
    result = Math.max(result, 1);

    for (int k = 0; k < 6; ++k) {
      int nextY = y + dy[k];
      int nextX = x + dx[k];

      if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= n) {
        continue;
      }

      if (map[nextY][nextX] == 1 && visit[nextY][nextX] == -1) {
        dfs(nextY, nextX, 1 - cnt);
        result = Math.max(result, 2);
      }

      if (visit[nextY][nextX] == cnt) {
        result = 3;
      }
    }
  }
}