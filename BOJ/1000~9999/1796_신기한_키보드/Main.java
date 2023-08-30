import java.util.*;
import java.io.*;

public class Main {
  static BufferedReader br;
  static BufferedWriter bw;
  static StringTokenizer st;
  static String s;
  static int maxCnt;
  static int result;
  static int[] minLoc;
  static int[] maxLoc;
  static int[][][] dp;

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
    st = new StringTokenizer(br.readLine());

    maxCnt = 0;
    minLoc = new int[26];
    maxLoc = new int[26];
    s = st.nextToken();
    result = 0;

    for (int i = 0; i < 26; ++i) {
      maxLoc[i] = -1;
      minLoc[i] = s.length();
    }

    for (int i = 0; i < s.length(); ++i) {
      if (minLoc[s.charAt(i) - 'a'] == s.length()) {
        ++maxCnt;
      }
      minLoc[s.charAt(i) - 'a'] = Math.min(minLoc[s.charAt(i) - 'a'], i);
      maxLoc[s.charAt(i) - 'a'] = Math.max(maxLoc[s.charAt(i) - 'a'], i);
    }

    dp = new int[2][maxCnt + 1][2];
  }

  public static void print() throws Exception {
    bw.write((Math.min(dp[0][maxCnt][0], dp[1][maxCnt][0]) + s.length()) + "\n");
    bw.close();
  }

  public static void calc() throws Exception {
    int cnt = 1;
    for (int i = 0; i < 26; ++i) {
      if (cnt > maxCnt) {
        return;
      }
      System.out.println("!!" + minLoc[i] + " " + maxLoc[i]);

      if (minLoc[i] == s.length()) {
        continue;
      }

      int dist1 = 0;
      int dist2 = 0;

      dist1 = Math.min(Math.abs(dp[0][cnt - 1][1] - maxLoc[i]) + dp[0][cnt - 1][0],
          Math.abs(dp[1][cnt - 1][1] - maxLoc[i]) + dp[1][cnt - 1][0])
          + Math.abs(maxLoc[i] - minLoc[i]);
      dist2 = Math.min(Math.abs(dp[0][cnt - 1][1] - minLoc[i]) + dp[0][cnt - 1][0],
          Math.abs(dp[1][cnt - 1][1] - minLoc[i]) + dp[1][cnt - 1][0])
          + Math.abs(minLoc[i] - maxLoc[i]);

      dp[0][cnt][0] = dist1;
      dp[1][cnt][0] = dist2;
      dp[0][cnt][1] = minLoc[i];
      dp[1][cnt][1] = maxLoc[i];
      System.out.println(dp[0][cnt][0] + " " + dp[1][cnt][0]);
      System.out.println(dp[0][cnt][1] + " " + dp[1][cnt][1]);
      ++cnt;
    }
  }
}