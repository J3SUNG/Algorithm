import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  static int n, m;
  static int[][] map;
  static int[][] visit;
  static int result;
  static int maxCnt;
  static Queue<Data> q;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void simulation() throws Exception {
    init();
    calc();
    print();
  }

  public static void init() throws Exception {
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    visit = new int[n][m];
    q = new LinkedList<>();
    result = 0;
    maxCnt = 0;

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    int[] my = { 0, 1, 0, -1 };
    int[] mx = { 1, 0, -1, 0 };

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (map[i][j] == 0) {
          continue;
        }
        q.add(new Data(i, j, 1));
        visit[i][j] = 1;
        while (!q.isEmpty()) {
          int y = q.peek().y;
          int x = q.peek().x;
          int cnt = q.peek().cnt;
          q.poll();

          if (maxCnt < cnt) {
            maxCnt = cnt;
            result = map[i][j] + map[y][x];
          } else if (maxCnt == cnt) {
            result = Math.max(result, map[i][j] + map[y][x]);
          }

          for (int k = 0; k < 4; ++k) {
            int nextY = y + my[k];
            int nextX = x + mx[k];

            if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m || map[nextY][nextX] == 0
                || visit[nextY][nextX] == 1) {
              continue;
            }

            visit[nextY][nextX] = 1;
            q.add(new Data(nextY, nextX, cnt + 1));
          }
        }

        for (int k = 0; k < n; ++k) {
          for (int l = 0; l < m; ++l) {
            visit[k][l] = 0;
          }
        }
      }
    }
  }

  public static class Data {
    int y;
    int x;
    int cnt;

    public Data(int y, int x, int cnt) {
      this.y = y;
      this.x = x;
      this.cnt = cnt;
    }
  }
}