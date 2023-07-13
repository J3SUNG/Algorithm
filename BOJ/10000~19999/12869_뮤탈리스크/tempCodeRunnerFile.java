import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    int n = Integer.parseInt(br.readLine());
    int result = 0;
    int[] arr = new int[3];
    int[][] calc = { { 1, 3, 9 }, { 1, 9, 3 }, { 3, 1, 9 }, { 3, 9, 1 }, { 9, 1, 3 }, { 9, 3, 1 } };
    boolean[][][] visit = new boolean[61][61][61];
    Queue<Data> q = new LinkedList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    q.add(new Data(0, 0, 0, 0));

    int[] compare = new int[3];
    while (!q.isEmpty()) {
      int a = q.peek().a;
      int b = q.peek().b;
      int c = q.peek().c;
      int cnt = q.peek().cnt;
      q.poll();

      for (int i = 0; i < 6; ++i) {
        compare[0] = a + calc[i][0];
        compare[1] = b + calc[i][1];
        compare[2] = c + calc[i][2];

        Arrays.sort(compare);

        if (visit[compare[0]][compare[1]][compare[2]]) {
          continue;
        }

        visit[compare[0]][compare[1]][compare[2]] = true;

        q.add(new Data(compare[0], compare[1], compare[2], cnt + 1));

        if (compare[0] >= arr[0] && compare[1] >= arr[1] && compare[2] >= arr[2]) {
          result = cnt + 1;

          while (!q.isEmpty()) {
            q.poll();
          }
          break;
        }

      }
    }

    bw.write(result + "\n");
    bw.close();
  }

  public static class Data {
    int a;
    int b;
    int c;
    int cnt;

    public Data(int a, int b, int c, int cnt) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.cnt = cnt;
    }
  }
}