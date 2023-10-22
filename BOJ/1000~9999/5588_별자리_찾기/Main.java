import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int n;
  static int m;
  static int result;
  static int[][] star;
  static int[][] map;
  static HashMap<String, Integer> hm;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void simulation() throws Exception {
    init();
    calc();
    print();
  }

  public static void init() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    result = 0;
    hm = new HashMap<String, Integer>();
    n = Integer.parseInt(br.readLine());
    star = new int[n][2];

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      star[i][0] = Integer.parseInt(st.nextToken());
      star[i][1] = Integer.parseInt(st.nextToken());
    }

    m = Integer.parseInt(br.readLine());
    map = new int[m][2];

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      map[i][0] = Integer.parseInt(st.nextToken());
      map[i][1] = Integer.parseInt(st.nextToken());
      hm.put(map[i][0] + " " + map[i][1], 1);
    }
  }

  public static void print() throws Exception {
    bw.close();
  }

  public static void calc() throws Exception {
    for (int i = 0; i < m; ++i) {
      int y = map[i][1] - star[0][1];
      int x = map[i][0] - star[0][0];
      boolean flag = true;

      for (int j = 0; j < n; ++j) {
        if (hm.containsKey((star[j][0] + x) + " " + (star[j][1] + y))) {
          continue;
        } else {
          flag = false;
          break;
        }
      }
      if (flag) {
        bw.write(x + " " + y + "\n");
        return;
      }
    }
  }
}