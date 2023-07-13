import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st = null;
  static int testcase;
  static int n;
  static int m;
  static int result;
  static int t;
  static ArrayList<ArrayList<Integer>> al;
  static int[] visit;

  public static void main(String[] args) throws Exception {
    simulation();
  }

  public static void simulation() throws Exception {
    while (true) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      ++t;

      if (n == 0 && m == 0) {
        break;
      }

      init();
      calc();
      print();
    }

    bw.close();
  }

  public static void init() throws Exception {
    result = 0;
    visit = new int[n + 1];
    al = new ArrayList<ArrayList<Integer>>();

    for (int i = 0; i <= n; ++i) {
      ArrayList<Integer> list = new ArrayList<Integer>();
      al.add(list);
    }

    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      al.get(a).add(b);
      al.get(b).add(a);
    }
  }

  public static void print() throws Exception {
    if (result == 0) {
      bw.write("Case " + t + ": No trees.\n");
    } else if (result == 1) {
      bw.write("Case " + t + ": There is one tree.\n");
    } else {
      bw.write("Case " + t + ": A forest of " + result + " trees.\n");
    }
  }

  public static void calc() throws Exception {
    for (int i = 1; i <= n; ++i) {
      if (visit[i] == 0) {
        visit[i] = 1;
        result = dfs(0, i) ? result + 1 : result;
      }
    }
  }

  public static boolean dfs(int prev, int index) throws Exception {
    boolean chk = true;
    for (int i = 0; i < al.get(index).size(); ++i) {
      if (!chk) {
        return false;
      }
      if (prev == al.get(index).get(i)) {
        continue;
      }
      if (visit[al.get(index).get(i)] == 1) {
        return false;
      }

      visit[al.get(index).get(i)] = 1;
      chk = dfs(index, al.get(index).get(i));
    }

    return chk;
  }
}