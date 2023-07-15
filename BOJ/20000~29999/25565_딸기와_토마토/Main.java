import java.io.*;
import java.util.*;

public class Main {
  static int n;

  static int m;
  static int k;
  static int cnt;
  static int[][] map;
  static ArrayList<Pair> al;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    cnt = 0;
    map = new int[n][m];
    al = new ArrayList<>();

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 1) {
          ++cnt;
        }
      }
    }

    cnt = k * 2 - cnt;

    if (cnt == k) {
      func1();
    } else if (cnt == 1) {
      func2();
    } else if (cnt > 1) {
      func3();
    }

    bw.write(cnt + "\n");
    for (int i = 0; i < al.size(); ++i) {
      bw.write((al.get(i).y + 1) + " " + (al.get(i).x + 1) + "\n");
    }

    bw.close();
  }

  public static void func1() {
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (map[i][j] == 1) {
          boolean chk = false;

          al.add(new Pair(i, j));
          if (j + 1 < m && map[i][j + 1] == 1) {
            chk = false;
          } else if (i + 1 < n && map[i + 1][j] == 1) {
            chk = true;
          }
          for (int l = 1; l < k; ++l) {
            if (chk) {
              al.add(new Pair(i + l, j));
            } else {
              al.add(new Pair(i, j + l));
            }
          }

          return;
        }
      }
    }
  }

  public static void func2() {
    int[] my = { 0, 0, 1, -1 };
    int[] mx = { 1, -1, 0, 0 };

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (map[i][j] == 1) {
          int c = 0;
          for (int k = 0; k < 4; ++k) {
            int nextY = i + my[k];
            int nextX = j + mx[k];

            if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || map[nextY][nextX] == 0) {
              continue;
            }

            if (k < 2) {
              c |= 1;
            } else {
              c |= 2;
            }
          }

          if (c == 3) {
            al.add(new Pair(i, j));
            return;
          }
        }
      }
    }
    func3();
  }

  public static void func3() {
    int c = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (map[i][j] == 1) {
          boolean chk = false;

          ++c;
          if (j + 1 < m && map[i][j + 1] == 1) {
            chk = false;
          } else if (i + 1 < n && map[i + 1][j] == 1) {
            chk = true;
          }
          for (int l = 1; l < k; ++l) {
            if (chk) {
              if (k - c <= cnt) {
                al.add(new Pair(i + l, j));
              }
              ++c;
            } else {
              if (k - c <= cnt) {
                al.add(new Pair(i, j + l));
              }
              ++c;
            }
          }

          return;
        }
      }
    }
  }

  public static class Pair {
    int y;
    int x;

    public Pair(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}