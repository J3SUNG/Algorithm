import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int result = 0;
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int[] arr = new int[m];
    Pair[] target = new Pair[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < n; ++i) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      target[i] = new Pair(y, x);
    }

    Arrays.sort(arr);

    for (int i = 0; i < n; ++i) {
      int left = 0;
      int right = m - 1;
      while (left <= right) {
        int mid = (left + right) / 2;

        if (Math.abs(arr[mid] - target[i].x) + target[i].y > l) {
          if (arr[mid] < target[i].x) {
            left = mid + 1;
          } else if (arr[mid] > target[i].x) {
            right = mid - 1;
          } else {
            break;
          }
        } else {
          ++result;
          break;
        }
      }
    }

    bw.write(result + "\n");
    bw.close();
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