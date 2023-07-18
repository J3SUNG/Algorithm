import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    int n = Integer.parseInt(br.readLine());
    ArrayList<Pair> al = new ArrayList<>();
    long[] sum = new long[n];

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());

      al.add(new Pair(x, a));
    }

    Collections.sort(al, (Pair a1, Pair a2) -> {
      return a1.loc - a2.loc;
    });

    sum[0] = al.get(0).num;
    for (int i = 1; i < n; ++i) {
      sum[i] = sum[i - 1] + al.get(i).num;
    }

    int left = 0;
    int right = n - 1;
    long dist = Long.MAX_VALUE;
    while (left <= right) {
      int mid = (left + right) / 2;

      if (sum[mid] >= sum[n - 1] - sum[mid]) {
        right = mid - 1;
        dist = Math.min(dist, al.get(mid).loc);
      } else {
        left = mid + 1;
      }
    }

    bw.write(dist + "\n");
    bw.close();
  }

  public static class Pair {
    int loc;
    int num;

    public Pair(int loc, int num) {
      this.loc = loc;
      this.num = num;
    }
  }
}