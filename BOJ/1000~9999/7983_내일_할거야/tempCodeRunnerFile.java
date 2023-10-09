import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    int answer = 0;
    int time = 0;
    int n = Integer.parseInt(br.readLine());
    Pair[] p = new Pair[n];

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      int value = Integer.parseInt(st.nextToken());
      int index = Integer.parseInt(st.nextToken());
      p[i] = new Pair(index, value);
    }

    Arrays.sort(p, (a, b) -> b.index - a.index);

    time = p[0].index - p[0].value;
    for (int i = 1; i < n; ++i) {
      int index = p[i].index;
      int value = p[i].value;

      if (index < time) {
        answer = Math.max(answer, time - index);
        time = index;
      }
      time = time - value;
    }
    answer = Math.max(answer, time - 0);

    bw.write(answer + "\n");
    bw.close();
  }

  public static class Pair {
    int index;
    int value;

    public Pair(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}
