import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int chk;
  static int[][] visit;
  static String result;
  static ArrayList<ArrayList<Integer>> al;
  static BufferedReader br;
  static BufferedWriter bw;

  public static void main(String[] args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    visit = new int[n][10];
    al = new ArrayList<>();
    result = "-1";

    for (int i = 0; i < n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());

      ArrayList<Integer> temp = new ArrayList<>();
      for (int j = 0; j < num; ++j) {
        temp.add(Integer.parseInt(st.nextToken()));
      }
      al.add(temp);
    }

    for (int i = 0; i < al.get(0).size(); ++i) {
      visit[0][al.get(0).get(i)] = 1;
      if (dfs(al.get(0).get(i), 1)) {
        chk = 1;
        break;
      }
    }

    if (chk == 1) {
      for (int i = result.length() - 1; i >= 0; --i) {
        bw.write(result.charAt(i) + "\n");
      }
    } else {
      bw.write(result);
    }

    bw.close();
  }

  public static boolean dfs(int prev, int day) throws Exception {
    if (n == day) {
      result = prev + "";
      return true;
    }
    for (int i = 0; i < al.get(day).size(); ++i) {
      if (al.get(day).get(i) == prev || visit[day][al.get(day).get(i)] == 1) {
        continue;
      }
      visit[day][al.get(day).get(i)] = 1;
      if (dfs(al.get(day).get(i), day + 1)) {
        result += prev + "";
        return true;
      }
    }
    return false;
  }
}
