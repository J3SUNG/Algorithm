import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int t = Integer.parseInt(st.nextToken());
    String result;

    for (int ts = 1; ts <= t; ++ts) {
      st = new StringTokenizer(br.readLine());
      String A = st.nextToken();
      String B = st.nextToken();
      String str = st.nextToken();
      int[][] visit = new int[201][201];
      Queue<Pair> q = new LinkedList<>();

      int left = 0;
      int right = 0;
      int index = 0;
      result = "no";

      q.add(new Pair(left, right, 0));
      while (!q.isEmpty()) {
        left = q.peek().left;
        right = q.peek().right;
        index = q.peek().index;
        q.poll();

        if (visit[left][right] == 1) {
          continue;
        }

        visit[left][right] = 1;

        if (left == A.length() && right == B.length()) {
          result = "yes";
          break;
        }

        if (left < A.length() && A.charAt(left) == str.charAt(index)) {
          q.add(new Pair(left + 1, right, index + 1));
        }
        if (right < B.length() && B.charAt(right) == str.charAt(index)) {
          q.add(new Pair(left, right + 1, index + 1));
        }
      }

      bw.write("Data set " + ts + ": " + result + "\n");
    }

    bw.close();
  }

  public static class Pair {
    int left;
    int right;
    int index;

    public Pair(int left, int right, int index) {
      this.left = left;
      this.right = right;
      this.index = index;
    }
  }
}