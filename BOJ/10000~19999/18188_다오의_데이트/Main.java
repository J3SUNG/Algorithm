import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static int m;
  static int moveCnt;
  static int sy, sx;
  static int ey, ex;
  static int[][] map;
  static int[][] move;
  static String result;
  static int resultCnt;
  static int[] resultPath;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    result = "NO";
    resultCnt = 0;
    String s;
    char[] resultMapping = { 'W', 'D', 'S', 'A' };

    for (int i = 0; i < n; ++i) {
      s = br.readLine();

      for (int j = 0; j < m; ++j) {
        if (s.charAt(j) == '@') {
          map[i][j] = 1;
        } else if (s.charAt(j) == '.') {
          map[i][j] = 0;
        } else if (s.charAt(j) == 'D') {
          map[i][j] = 0;
          sy = i;
          sx = j;
        } else if (s.charAt(j) == 'Z') {
          map[i][j] = 0;
          ey = i;
          ex = j;
        }
      }
    }

    moveCnt = Integer.parseInt(br.readLine());
    move = new int[moveCnt][2];
    resultPath = new int[moveCnt];

    for (int i = 0; i < moveCnt; ++i) {
      s = br.readLine();
      for (int j = 0; j < 2; ++j) {
        if (s.charAt(j * 2) == 'W') {
          move[i][j] = 0;
        } else if (s.charAt(j * 2) == 'A') {
          move[i][j] = 3;
        } else if (s.charAt(j * 2) == 'S') {
          move[i][j] = 2;
        } else if (s.charAt(j * 2) == 'D') {
          move[i][j] = 1;
        }
      }
    }

    dfs(sy, sx, 0);

    bw.write(result + "\n");

    for (int i = 0; i < resultCnt; ++i) {
      bw.write(resultMapping[resultPath[i]] + "");
    }

    bw.close();
  }

  public static boolean dfs(int y, int x, int cnt) {
    int[] my = { -1, 0, 1, 0 };
    int[] mx = { 0, 1, 0, -1 };
    boolean chk = false;
    boolean endChk;

    if (y == ey && x == ex) {
      result = "YES";
      resultCnt = cnt;
      return true;
    }

    if (cnt == moveCnt) {
      return false;
    }

    endChk = false;
    for (int i = 0; i < 2; ++i) {
      int nextY = y + my[move[cnt][i]];
      int nextX = x + mx[move[cnt][i]];

      if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || map[nextY][nextX] == 1) {
        if (i == 1 && endChk) {
          return false;
        } else {
          endChk = true;
        }

        continue;
      } else {
        chk = dfs(nextY, nextX, cnt + 1);
      }

      if (chk) {
        resultPath[cnt] = move[cnt][i];
        return true;
      }
    }

    return false;
  }
}