import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int q = Integer.parseInt(st.nextToken());
    int[][] map = new int[r + 1][c + 1];
    int result = 0;

    for (int i = 1; i <= r; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= c; ++j) {
        int num = Integer.parseInt(st.nextToken());
        map[i][j] = map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1] + num;
      }
    }

    for (int i = 0; i < q; ++i) {
      st = new StringTokenizer(br.readLine());
      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int div = (y2 - y1 + 1) * (x2 - x1 + 1);

      result = (map[y2][x2] - map[y1 - 1][x2] - map[y2][x1 - 1] + map[y1 - 1][x1 - 1]) / div;
      bw.write(result + "\n");
    }

    bw.close();
  }
}