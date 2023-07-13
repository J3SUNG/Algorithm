import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int n;
  static int m;
  static int cnt;
  static int result;
  static int bombCnt;
  static String str;
  static int[][] map;
  static int[][] visit;

  public static void main(String[] args) throws Exception {
    init();
    simulation();
  }

  public static void init() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = 12;
    m = 6;
    result = 0;
    bombCnt = 1;
    map = new int[n][m];
    visit = new int[n][m];

    for (int i = 0; i < n; ++i) {
      str = br.readLine();
      for (int j = 0; j < m; ++j) {
        char c = str.charAt(j);
        if (c == '.') {
          map[i][j] = 0;
        } else if (c == 'R') {
          map[i][j] = 1;
        } else if (c == 'G') {
          map[i][j] = 2;
        } else if (c == 'B') {
          map[i][j] = 3;
        } else if (c == 'Y') {
          map[i][j] = 4;
        } else if (c == 'P') {
          map[i][j] = 5;
        }
      }
    }
  }

  public static void simulation() throws Exception {
    while (bombCnt > 0) {
      find();
      gravity();
    }

    print();
  }

  public static void gravity() {
    if (bombCnt == 0) {
      return;
    }

    for (int j = 0; j < m; ++j) {
      int index = -1;
      for (int i = n - 1; i >= 0; --i) {
        if (index == -1 && map[i][j] == 0) {
          index = i;
        }

        if (index != -1 && map[i][j] > 0) {
          map[index][j] = map[i][j];
          map[i][j] = 0;
          --index;
        }
      }
    }
  }

  public static void find() {
    bombCnt = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (map[i][j] > 0) {
          cnt = 1;
          initVisit();
          bomb(i, j, map[i][j]);
          if (cnt >= 4) {
            ++bombCnt;
            remove(i, j, map[i][j]);
          }
        }
      }
    }
    result = bombCnt > 0 ? result + 1 : result;
  }

  public static void initVisit() {
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        visit[i][j] = 0;
      }
    }
  }

  public static void remove(int y, int x, int t) {
    int[] my = { 0, 1, 0, -1 };
    int[] mx = { 1, 0, -1, 0 };

    map[y][x] = 0;

    for (int i = 0; i < 4; ++i) {
      int nextY = y + my[i];
      int nextX = x + mx[i];

      if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || map[nextY][nextX] != t) {
        continue;
      }

      remove(nextY, nextX, t);
    }
  }

  public static void bomb(int y, int x, int t) {
    int[] my = { 0, 1, 0, -1 };
    int[] mx = { 1, 0, -1, 0 };

    visit[y][x] = 1;

    for (int i = 0; i < 4; ++i) {
      int nextY = y + my[i];
      int nextX = x + mx[i];

      if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || map[nextY][nextX] != t || visit[nextY][nextX] == 1) {
        continue;
      }
      ++cnt;

      bomb(nextY, nextX, t);
    }
  }

  public static void print() throws Exception {
    bw.write(result + "\n");
    bw.close();
  }
}