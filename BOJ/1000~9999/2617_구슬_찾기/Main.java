import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static int n;
  static int m;
  static int k;
  static int[][] map;
  static int[][] calcMap1;
  static int[][] calcMap2;
  static int result = 987654321;

  public static void main(String[] args) throws Exception {
    init();
    simulation();
  }

  public static void init() throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    map = new int[n + 1][m + 1];
    calcMap1 = new int[n + 1][m + 1];
    calcMap2 = new int[n + 1][m + 1];

    for (int i = 1; i <= n; ++i) {
      String s = br.readLine();
      for (int j = 1; j <= m; ++j) {
        map[i][j] = s.charAt(j - 1) == 'W' ? 0 : 1;
      }
    }
  }

  public static void simulation() throws Exception {
    drawCalcMap();
    checkCalcMap();

    bw.write(result + "");
    bw.close();
  }

  public static void countCalcMap(int y, int x) {
    int cnt1 = calcMap1[y + k - 1][x + k - 1] - calcMap1[y + k - 1][x - 1] - calcMap1[y - 1][x + k - 1]
        + calcMap1[y - 1][x - 1];
    int cnt2 = calcMap2[y + k - 1][x + k - 1] - calcMap2[y + k - 1][x - 1] - calcMap2[y - 1][x + k - 1]
        + calcMap2[y - 1][x - 1];
    int cnt = cnt1 < cnt2 ? cnt1 : cnt2;
    result = Math.min(result, cnt);
  }

  public static void checkCalcMap() {
    for (int i = 1; i <= n - k + 1; ++i) {
      for (int j = 1; j <= m - k + 1; ++j) {
        countCalcMap(i, j);
      }
    }
  }

  public static void drawCalcMap() {
    for (int i = 1; i <= n; ++i) {
      for (int j = 1; j <= m; ++j) {
        calcMap1[i][j] = calcMap1[i - 1][j] + calcMap1[i][j - 1] - calcMap1[i - 1][j - 1];
        calcMap2[i][j] = calcMap2[i - 1][j] + calcMap2[i][j - 1] - calcMap2[i - 1][j - 1];
        if ((i + j) % 2 == 0 && map[i][j] == 0) {
          ++calcMap1[i][j];
        } else if ((i + j) % 2 == 1 && map[i][j] == 1) {
          ++calcMap1[i][j];
        }

        if ((i + j) % 2 == 1 && map[i][j] == 0) {
          ++calcMap2[i][j];
        } else if ((i + j) % 2 == 0 && map[i][j] == 1) {
          ++calcMap2[i][j];
        }
      }
    }
  }
}