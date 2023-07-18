import java.util.*;
import java.io.*;

public class Main {
  static int M, N, L;
  static int[] x;
  static Loc[] animal;
  static int count = 0;

  static class Loc {
    int x, y;

    public Loc(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    x = new int[M];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < M; i++) {
      x[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(x);

    animal = new Loc[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      animal[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(animal, (o1, o2) -> o1.x - o2.x);

    for (int i = 0; i < N; i++) {
      int l = 0;
      int r = M - 1;
      int m = (l + r) / 2;

      if (animal[i].y > L) {
        continue;
      }

      while (l <= r) {

        if (Math.abs(animal[i].x - x[m]) <= L - animal[i].y) {
          count++;
          break;
        }

        if (animal[i].x - x[m] > 0) {
          l = m + 1;
          m = (l + r) / 2;
          continue;
        } else if (animal[i].x - x[m] < 0) {
          r = m - 1;
          m = (l + r) / 2;
          continue;
        } else if (animal[i].x == x[m]) {
          break;
        }
      }
    }

    System.out.println(count);

  }
}