import java.util.*;
import java.io.*;

public class Main {
  static class Number implements Comparable<Number> {
    int idx;
    int num;

    public Number(int idx, int num) {
      this.idx = idx;
      this.num = num;
    }

    public int compareTo(Number o) {
      return this.num == o.num ? this.idx - o.idx : this.num - o.num;
    }
  }

  static int r, c, k;

  static int row = 3, col = 3;

  static int map[][], count[][];

  static int ans = 0;

  static int[][] visited;

  static PriorityQueue<Number> pq = new PriorityQueue<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    map = new int[101][101];
    count = new int[101][101];

    for (int i = 1; i <= 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= 3; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (ans <= 100) {
      System.out.println(row + " " + col);
      check();
    }
    System.out.println(-1);
  }

  public static void check() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        sb.append(map[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
    System.out.println();

    if (map[r][c] == k) {
      System.out.println(ans);
      System.exit(0);
    }

    ans++;

    if (row >= col) {
      R();
    } else {
      C();
    }

  }

  public static void R() {
    count = new int[101][101];

    for (int i = 1; i <= 100; i++) {
      visited = new int[101][2];

      for (int j = 1; j <= 100; j++) {
        int temp = map[i][j];

        if (temp != 0) {
          visited[temp][0] = temp;
          visited[temp][1]++;
        }
      }

      for (int j = 1; j <= 100; j++) {
        if (visited[j][1] != 0) {
          pq.offer(new Number(visited[j][0], visited[j][1]));
        }
      }

      int index = 1;
      while (!pq.isEmpty()) {
        Number cur = pq.poll();
        count[i][index++] = cur.idx;
        count[i][index++] = cur.num;
      }
    }

    max();

    map = new int[101][101];
    for (int i = 1; i <= 100; i++) {
      for (int j = 1; j <= 100; j++) {
        if (count[i][j] == 0) {
          continue;
        }
        map[i][j] = count[i][j];
      }
    }

  }

  public static void C() {
    count = new int[101][101];

    for (int i = 1; i <= 100; i++) {
      visited = new int[101][2];

      for (int j = 1; j <= 100; j++) {
        int temp = map[j][i];

        if (temp != 0) {
          visited[temp][0] = temp;
          visited[temp][1]++;
        }
      }

      for (int j = 1; j <= 100; j++) {
        if (visited[j][1] != 0) {
          pq.offer(new Number(visited[j][0], visited[j][1]));
        }
      }

      int index = 1;
      while (!pq.isEmpty()) {
        Number cur = pq.poll();
        count[index++][i] = cur.idx;
        count[index++][i] = cur.num;
      }

    }

    max();

    map = new int[101][101];
    for (int i = 1; i <= 100; i++) {
      for (int j = 1; j <= 100; j++) {
        if (count[i][j] == 0) {
          continue;
        }
        map[i][j] = count[i][j];
      }
    }

  }

  public static void max() {
    int tmp;
    row = 0;
    col = 0;
    for (int i = 1; i <= 100; i++) {
      tmp = 0;
      for (int j = 1; j <= 100; j++) {
        if (count[i][j] == 0) {
          continue;
        }
        tmp++;
      }
      col = Math.max(col, tmp);
    }

    for (int i = 1; i <= 100; i++) {
      tmp = 0;
      for (int j = 1; j <= 100; j++) {
        if (count[j][i] == 0) {
          continue;
        }
        tmp++;
      }
      row = Math.max(row, tmp);
    }
  }

}