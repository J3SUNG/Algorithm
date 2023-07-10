import java.util.*;
import java.io.*;

public class Main {
  static int result;
  static int n;
  static int c;
  static int[] arr;
  static int[] dist;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    result = 1_000_000_000;
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    arr = new int[n];
    dist = new int[n];

    arr[0] = Integer.parseInt(br.readLine());
    for (int i = 1; i < n; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    for (int i = 1; i < n; ++i) {
      dist[i] = arr[i] - arr[i - 1];
    }

    while (true) {
      if (search(0, 0, 0, result)) {

      }
    }

    bw.write(result + "\n");
    bw.close();
  }

  public static boolean search(int index, int prev, int cnt, int num) {
    if (cnt == c) {
      result = Math.min(result, num);
      return true;
    }

    if (dist[index] + prev >= num) {
      return search(index + 1, 0, cnt + 1, num);
    }

    return false;
  }
}