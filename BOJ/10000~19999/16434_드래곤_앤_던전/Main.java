import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    Long a = Long.parseLong(st.nextToken());

    int[][] map = new int[n][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      map[i][0] = Integer.parseInt(st.nextToken());
      map[i][1] = Integer.parseInt(st.nextToken());
      map[i][2] = Integer.parseInt(st.nextToken());
    }

    Long left = 1L;
    Long right = 999999000001L * n;
    result = 999999000001L * n;
    while (left <= right) {
      Long attack = a;
      Long maxHp = (left + right) / 2;
      Long hp = maxHp;
      boolean isKill = true;

      for (int i = 0; i < n; ++i) {
        if (map[i][0] == 1) {
          hp -= map[i][1] * ((map[i][2] - 1) / attack);
          if (hp <= 0) {
            isKill = false;
            break;
          }
        } else if (map[i][0] == 2) {
          attack += map[i][1];
          hp = Math.min(hp + map[i][2], maxHp);
        }
      }

      if (isKill) {
        right = maxHp - 1L;
      } else {
        left = maxHp + 1L;
      }
    }

    bw.write(left + "");
    bw.close();
  }
}