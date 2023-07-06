import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int m;
  static int num;
  static int ySize;
  static int xSize;
  static int tempSize;
  static int[][] map;
  static int[] cnt;
  static int result;
  static ArrayList<Data> al;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken()) - 1;
    m = Integer.parseInt(st.nextToken()) - 1;
    num = Integer.parseInt(st.nextToken());
    ySize = 3;
    xSize = 3;
    map = new int[101][101];
    cnt = new int[101];
    result = 0;

    for (int i = 0; i < 3; ++i) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    while (true) {
      if (map[n][m] == num) {
        break;
      }

      if (result > 100) {
        result = -1;
        break;
      }

      ++result;

      int size;
      int d;
      if (xSize <= ySize) {
        size = ySize;
        d = 0;
      } else {
        size = xSize;
        d = 1;
      }

      tempSize = 0;
      for (int i = 0; i < size; ++i) {
        init();

        count(i, d);

        alCount(d);

        alSort();

        change(i, d);
      }

      if (d == 0) {
        xSize = tempSize;
      } else {
        ySize = tempSize;
      }
    }

    bw.write(result + "\n");
    bw.close();

  }

  public static void alSort() {
    al.sort((a, b) -> {
      if (a.num == b.num) {
        return a.index - b.index;
      } else {
        return a.num - b.num;
      }
    });
  }

  public static void init() {
    al = new ArrayList<>();
    for (int i = 0; i < 101; ++i) {
      cnt[i] = 0;
    }
  }

  public static void count(int i, int d) {
    if (d == 0) {
      for (int j = 0; j < xSize; ++j) {
        if (map[i][j] == 0) {
          continue;
        }
        ++cnt[map[i][j]];
        map[i][j] = 0;
      }
    } else {
      for (int j = 0; j < ySize; ++j) {
        if (map[j][i] == 0) {
          continue;
        }
        ++cnt[map[j][i]];
        map[j][i] = 0;
      }
    }
  }

  public static void alCount(int d) {
    int size = 0;

    for (int i = 0; i < 101; ++i) {
      if (cnt[i] == 0) {
        continue;
      }
      al.add(new Data(cnt[i], i));
      ++size;
    }

    tempSize = Math.max(tempSize, size * 2);
  }

  public static void change(int index, int d) {
    if (d == 0) {
      for (int i = 0; i < al.size(); ++i) {
        map[index][2 * i] = al.get(i).index;
        map[index][2 * i + 1] = al.get(i).num;
      }

      int next = al.size() * 2;
      for (int i = next; i < 101; ++i) {
        if (map[index][i] == 0) {
          break;
        } else {
          map[index][i] = 0;
        }
      }
    } else {
      for (int i = 0; i < al.size(); ++i) {
        map[2 * i][index] = al.get(i).index;
        map[2 * i + 1][index] = al.get(i).num;
      }

      int next = al.size() * 2;
      for (int i = next; i < 101; ++i) {
        if (map[i][index] == 0) {
          break;
        } else {
          map[i][index] = 0;
        }
      }
    }
  }

  public static class Data {
    int num;
    int index;

    public Data(int num, int index) {
      this.num = num;
      this.index = index;
    }
  }
}