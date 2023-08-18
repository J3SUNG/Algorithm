import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    double a = Long.parseLong(st.nextToken());
    double result = 9e18;

    int[][] map = new int[n][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      map[i][0] = Integer.parseInt(st.nextToken());
      map[i][1] = Integer.parseInt(st.nextToken());
      map[i][2] = Integer.parseInt(st.nextToken());
    }

    double left = 1;
    double right = 9e18;
    while (left <= right) {
      double attack = a;
      double maxHp = Math.floor((left + right) / 2);
      double hp = Math.floor(maxHp);
      boolean isKill = true;

      for (int i = 0; i < n; ++i) {
        if (map[i][0] == 1) {
          hp -= map[i][1] * Math.floor((map[i][2] - 1) / attack);
          if (hp <= 0) {
            isKill = false;
            break;
          }
        } else if (map[i][0] == 2) {
          attack += map[i][1];
          hp += map[i][2];
          if (hp > maxHp) {
            hp = maxHp;
          }
        }
      }

      if (isKill) {
        result = Math.min(result, maxHp);
        right = maxHp - 1L;
      } else {
        left = maxHp + 1L;
      }
    }

    bw.write(String.format("%.0f", result) + "");
    bw.close();
  }
}