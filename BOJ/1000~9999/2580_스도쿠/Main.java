import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int[][] map;
  static int[][] chk;
  static int maxBit;
  static int[] numBit;
  static ArrayList<Pair> al;;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    al = new ArrayList<>();
    map = new int[9][9];
    chk = new int[3][9];
    maxBit = 1022;

    for (int i = 0; i < 9; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 0) {
          al.add(new Pair(i, j));
        }
      }
    }

    for (int i = 0; i < 9; ++i) {
      int bit = 0;
      for (int j = 0; j < 9; ++j) {
        if (map[i][j] == 0) {
          continue;
        }
        bit = bit | (1 << map[i][j]);
      }
      chk[0][i] = bit;
    }

    for (int i = 0; i < 9; ++i) {
      int bit = 0;
      for (int j = 0; j < 9; ++j) {
        if (map[j][i] == 0) {
          continue;
        }
        bit = bit | (1 << map[j][i]);
      }
      chk[1][i] = bit;
    }

    for (int h = 0; h < 3; ++h) {
      for (int w = 0; w < 3; ++w) {
        int bit = 0;
        for (int i = 0; i < 3; ++i) {
          for (int j = 0; j < 3; ++j) {
            if (map[(h * 3) + i][(w * 3) + j] == 0) {
              continue;
            }
            bit = bit | (1 << map[(h * 3) + i][(w * 3) + j]);
          }
        }
        chk[2][(h * 3) + w] = bit;
      }
    }

    dfs(0);

    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        bw.write(map[i][j] + " ");
      }
      bw.write("\n");
    }

    bw.close();
  }

  public static boolean dfs(int index) {
    if (index == al.size()) {
      return true;
    }

    int y = al.get(index).y;
    int x = al.get(index).x;
    int bit = chk[0][y] | chk[1][x] | chk[2][(y / 3) * 3 + (x / 3)];

    if (bit == maxBit) {
      return false;
    }

    boolean result = false;
    for (int i = 1; i <= 9; ++i) {
      if ((bit & (1 << i)) != 0) {
        continue;
      }
      map[y][x] = i;
      chk[0][y] = chk[0][y] | (1 << i);
      chk[1][x] = chk[1][x] | (1 << i);
      chk[2][(y / 3) * 3 + (x / 3)] = chk[2][(y / 3) * 3 + (x / 3)] | (1 << i);

      if (dfs(index + 1)) {
        result = true;
        break;
      } else {
        map[y][x] = 0;
        chk[0][y] = chk[0][y] & (1022 - (1 << i));
        chk[1][x] = chk[1][x] & (1022 - (1 << i));
        chk[2][(y / 3) * 3 + (x / 3)] = chk[2][(y / 3) * 3 + (x / 3)] & (1022 - (1 << i));
      }
    }

    return result;
  }

  public static class Pair {
    int y;
    int x;

    public Pair(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}