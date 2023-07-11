import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static int w;
  static int t;
  static int k;
  static int result;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    result = 0;
    int[] fire = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      fire[i] = Integer.parseInt(st.nextToken());
    }

    dfs(w - 1, 1, fire);

    bw.write(result + "\n");
    bw.close();
  }

  public static void dfs(int loc, int time, int[] fire) {
    int cnt = 0;
    int[] move = { -1, 0, 1 };
    int[] temp = new int[n];
    
    cnt = fireCalc(fire);
    
    System.out.println("loc = " + loc + " time = " + time + " time = " + time);
    if (cnt < n - k) {
      return;
    }

    if (time == t) {
      ++result;
    }

    copyArr(fire, temp);

    for (int i = 0; i < 3; ++i) {
      int nextLoc = loc + move[i];

      if (nextLoc < 0 || nextLoc >= n) {
        continue;
      }

      dfs(nextLoc, time + 1, fire);
    }
  }

  public static int fireCalc(int[] fire) {
    int prev = 0;
    int cnt = 0;
    for (int i = 0; i < n; ++i) {
      fire[i] = prev == 0 ? fire[i] - 2 : fire[i] - 1;

      if (i + 1 < n) {
        fire[i] = fire[i + 1] == 0 ? fire[i] - 1 : fire[i];
      }

      if (fire[i] < 0) {
        fire[i] = 0;
        ++cnt;
      }
    }

    return cnt;
  }

  public static void copyArr(int[] fire, int[] temp) {
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        temp[i] = fire[i];
      }
    }
  }
}