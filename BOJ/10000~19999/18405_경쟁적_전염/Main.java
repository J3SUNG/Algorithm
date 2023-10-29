import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;
  static int n, k, s;
  static int[][] map;
  static int x, y;
  static Queue<Virus> q;
  static ArrayList<Virus> al = new ArrayList<>();

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
    k = Integer.parseInt(st.nextToken());
    map = new int[n][n];
    q = new LinkedList<>();

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] > 0) {
          al.add(new Virus(i, j, map[i][j]));
        }
      }
    }

    Collections.sort(al, (a, b) -> a.num - b.num);

    for (int i = 0; i < al.size(); ++i) {
      q.add(al.get(i));
    }

    st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken()) - 1;
    x = Integer.parseInt(st.nextToken()) - 1;
  }

  public static void print() throws Exception {
    bw.write(map[y][x] + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    int[] my = { 0, 1, 0, -1 };
    int[] mx = { 1, 0, -1, 0 };

    for (int i = 0; i < s; ++i) {
      int size = q.size();
      for (int j = 0; j < size; ++j) {
        int y = q.peek().y;
        int x = q.peek().x;
        int num = q.peek().num;
        q.poll();

        for (int k = 0; k < 4; ++k) {
          int nextY = y + my[k];
          int nextX = x + mx[k];

          if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n) {
            continue;
          }

          if (map[nextY][nextX] == 0) {
            map[nextY][nextX] = num;
            q.add(new Virus(nextY, nextX, num));
          }
        }
      }
    }
  }

  public static class Virus {
    int y;
    int x;
    int num;

    public Virus(int y, int x, int num) {
      this.y = y;
      this.x = x;
      this.num = num;
    }
  }
}